package software_testing.text.characters;

import lombok.Getter;
import software_testing.text.abstract_classes.SmallSpaceObject;
import software_testing.text.interfaces.Thinkable;

import java.util.ArrayList;

public class PetuniaPot extends SmallSpaceObject implements Thinkable {
    @Getter
    private ArrayList<String> potThoughts;

    public PetuniaPot(String name, double weight, double x, double y, double z, double maxOwnSpeed) {
        super(name, weight, x, y, z, maxOwnSpeed);
        this.potThoughts = new ArrayList<>();
    }

    @Override
    public void addThought(String thought) {
        System.out.println("У горшка с петуньей " + this.getName() + " появилась мысль: " + thought);
        potThoughts.add(thought);
    }

    @Override
    public void allThoughtsList() {
        System.out.println("Список всех мыслей горшка с петуньей :");
        for (String thought : potThoughts) {
            System.out.println("> " + thought);
        }
    }

    @Override
    public void land(Planet planet) {
        System.out.println("Горшок с петуньей " + this.getName() + " приближается к планете " + planet.getName());
        addThought("Опять?! О нет, только не это!");
        System.out.println("Горшок с петуньей " + this.getName() + " пытается безопасно приземлиться");
        if (isAliveAfterLanding(planet)) {
            System.out.println("Горшок с петуньей " + this.getName() + " успешно приземлился на планету");
            System.out.println("Текущие координаты горшка: x = " + this.getX() + "; y = " + this.getY() + "; z = " + this.getZ());
            addThought("Вау! А почему я был уверен, что разобьюсь?");
        } else {
            System.out.println("Горшок с петуньей " + this.getName() + " разбился при приземлении");
            addThought("Многие считают, что если бы мы точно знали, почему гоpшок с петунией так подумал, мы знали бы много больше о пpиpоде Вселенной, чем знаем сейчас");
            allThoughtsList();
        }
    }
}
