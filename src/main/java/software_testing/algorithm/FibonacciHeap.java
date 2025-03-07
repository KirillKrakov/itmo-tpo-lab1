package software_testing.algorithm;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class FibonacciHeap {
    public static class Node {
        @Getter
        int key, degree;
        @Getter
        boolean marked;
        @Getter
        Node parent, child, left, right;

        Node(int key) {
            this.key = key;
            this.degree = 0;
            this.marked = false;
            this.parent = null;
            this.child = null;
            this.left = this;
            this.right = this;
        }
    }

    private Node min;
    private int size;

    public FibonacciHeap() {
        this.min = null;
        this.size = 0;
    }

    public Node getMinNode() {
        return this.min;
    }

    public void insert(int key) {
        Node node = new Node(key);
        min = mergeNodes(min, node);
        size++;
    }

    public int getMin() {
        if (min == null) throw new IllegalStateException("Heap is empty");
        return min.key;
    }

    public int extractMin() {
        if (min == null) throw new IllegalStateException("Heap is empty");
        Node oldMin = min;
        if (oldMin.child != null) {
            Node child = oldMin.child;
            do {
                Node next = child.right;
                mergeNodes(min, child);
                child.parent = null;
                child = next;
            } while (child != oldMin.child);
        }
        removeNode(oldMin);
        if (oldMin == oldMin.right) {
            min = null;
        } else {
            min = oldMin.right;
            consolidate();
        }
        size--;
        return oldMin.key;
    }

    private void consolidate() {
        Map<Integer, Node> degreeMap = new HashMap<>();
        Node[] nodes = collectRoots();

        for (Node node : nodes) {
            if (node == null) continue;

            while (degreeMap.containsKey(node.degree)) {
                Node other = degreeMap.remove(node.degree);
                if (other == null) break;
                node = linkNodes(node, other);
            }
            degreeMap.put(node.degree, node);
        }

        min = null;
        for (Node node : degreeMap.values()) {
            if (node != null) {
                min = mergeNodes(min, node);
            }
        }
    }

    private Node linkNodes(Node a, Node b) {
        if (a.key > b.key) {
            Node temp = a; a = b; b = temp;
        }
        removeNode(b);
        b.parent = a;
        a.child = mergeNodes(a.child, b);
        a.degree++;
        b.marked = false;
        return a;
    }

    public void decreaseKey(Node node, int newKey) {
        if (newKey > node.key) throw new IllegalArgumentException("New key is greater than current key");
        node.key = newKey;
        if (node.parent != null && node.key < node.parent.key) {
            cut(node);
        }
        if (node.key < min.key) {
            min = node;
        }
    }

    private void cut(Node node) {
        Node parent = node.parent;
        removeNode(node);
        node.parent = null;
        node.marked = false;
        min = mergeNodes(min, node);
        if (parent != null) {
            if (parent.marked) {
                cut(parent);
            } else {
                parent.marked = true;
            }
        }
    }

    private Node[] collectRoots() {
        if (min == null) return new Node[0];

        Node[] roots = new Node[size];
        int count = 0;
        Node start = min;
        Node current = start;
        do {
            if (current != null) {
                roots[count++] = current;
            }
            current = current.right;
        } while (current != start);

        return java.util.Arrays.copyOf(roots, count);
    }

    private Node mergeNodes(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        a.right.left = b.left;
        b.left.right = a.right;
        a.right = b;
        b.left = a;
        return (a.key < b.key) ? a : b;
    }

    private void removeNode(Node node) {
        node.left.right = node.right;
        node.right.left = node.left;
    }

    public boolean isEmpty() {
        return min == null;
    }

    public int size() {
        return size;
    }

}
