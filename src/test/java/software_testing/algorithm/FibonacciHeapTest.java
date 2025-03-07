package software_testing.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {

    @Test
    public void testInsertionAndMin() {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(8);
        assertEquals(heap.getMinNode().getLeft(), heap.getMinNode().getRight());
        FibonacciHeap.Node node8 = heap.getMinNode();
        heap.insert(3);
        assertEquals(node8.getKey(),heap.getMinNode().getRight().getKey());
        heap.insert(15);
        assertEquals(3, heap.getMin(), "Минимальный элемент должен быть 3");
    }

    @Test
    public void testExtractMin() {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(10);
        heap.insert(2);
        heap.insert(7);
        assertEquals(2, heap.extractMin(), "Минимальный элемент должен быть 2");
        assertEquals(7, heap.getMin(), "Новый минимальный элемент должен быть 7");
    }

    @Test
    public void testDecreaseKey() {
        FibonacciHeap heap = new FibonacciHeap();
        FibonacciHeap.Node nodeA = new FibonacciHeap.Node(12);
        FibonacciHeap.Node nodeB = new FibonacciHeap.Node(25);
        heap.insert(nodeA.key);
        heap.insert(nodeB.key);
        assertEquals(12, heap.getMin(), "Минимальный элемент должен быть 12");
        heap.decreaseKey(nodeB, 5);
        assertEquals(5, heap.getMin(), "После уменьшения ключа, минимальный элемент должен быть 5");
    }

    @Test
    public void testIsEmpty() {
        FibonacciHeap heap = new FibonacciHeap();
        assertTrue(heap.isEmpty(), "Куча должна быть пустой после создания");
        heap.insert(1);
        assertFalse(heap.isEmpty(), "Куча не должна быть пустой после вставки элемента");
        heap.extractMin();
        assertTrue(heap.isEmpty(), "Куча снова должна быть пуста");
    }

    @Test
    public void testGetMinOnEmptyHeap() {
        FibonacciHeap heap = new FibonacciHeap();
        Assertions.assertThrows(IllegalStateException.class, heap::getMin, "Получение минимального из пустой кучи должно выбрасывать исключение");
    }

    @Test
    public void testExtractMinOnEmptyHeap() {
        FibonacciHeap heap = new FibonacciHeap();
        Assertions.assertThrows(IllegalStateException.class, heap::extractMin, "Извлечение минимального из пустой кучи должно выбрасывать исключение");
    }

    @Test
    public void testIncreaseKey() {
        FibonacciHeap heap = new FibonacciHeap();
        FibonacciHeap.Node node = new FibonacciHeap.Node(5);
        heap.insert(node.key);
        Assertions.assertThrows(IllegalArgumentException.class, () -> { heap.decreaseKey(node,7); }, "Извлечение минимального из пустой кучи должно выбрасывать исключение");
    }

    @Test
    public void testSize() {
        FibonacciHeap heap = new FibonacciHeap();
        assertEquals(0, heap.size(), "Размер должен быть 0 после создания");
        heap.insert(4);
        heap.insert(9);
        assertEquals(2, heap.size(), "Размер должен быть 2 после двух вставок");
        heap.extractMin();
        assertEquals(1, heap.size(), "Размер должен уменьшиться до 1 после удаления минимального элемента");
    }
}
