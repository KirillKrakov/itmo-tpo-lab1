package software_testing.text.characters;

import lombok.Getter;
import software_testing.text.abstract_classes.SmallSpaceObject;
import software_testing.text.interfaces.Thinkable;

import java.util.ArrayList;

public class Whale extends SmallSpaceObject implements Thinkable {
    @Getter
    private ArrayList<String> whaleThoughts;

    public Whale(String name, double weight, double x, double y, double z, double maxOwnSpeed) {
        super(name, weight, x, y, z, maxOwnSpeed);
        this.whaleThoughts = new ArrayList<>();
        System.out.println("В звёздной системе появился кит по имени " + this.getName());
    }

    @Override
    public void addThought(String thought) {
        System.out.println("У кита по имени " + this.getName() + " появилась мысль: " + thought);
        whaleThoughts.add(thought);
    }

    @Override
    public void allThoughtsList() {
        System.out.println("Список всех мыслей кита по имени " + this.getName() + " :");
        for (String thought : whaleThoughts) {
            System.out.println("> " + thought);
        }
    }

    @Override
    public void land(Planet planet) {
        System.out.println("Кит по имени " + this.getName() + " приближается к планете " + planet.getName());
        addThought("Эй! Что это - так быстpо летит навстpечу? Такое большое, и кpуглое, и плоское...");
        addThought("Надо дать ему подходящее имя. Интеpесно, мы с ним подpужимся?");
        System.out.println("Кит по имени " + this.getName() + " пытается безопасно приземлиться");
        if (isAliveAfterLanding(planet)) {
            System.out.println("Кит по имени " + this.getName() + " успешно приземлился на планету");
            System.out.println("Текущие координаты кита: x = " + this.getX() + "; y = " + this.getY() + "; z = " + this.getZ());
            addThought("Вот это да! Как тут красиво!");
        } else {
            System.out.println("Кит по имени " + this.getName() + " разбился при приземлении");
            addThought("И дальше, после внезапного мокpого шлепка - тишина");
            allThoughtsList();
        }
    }
}
