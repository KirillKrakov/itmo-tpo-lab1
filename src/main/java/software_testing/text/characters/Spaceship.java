package software_testing.text.characters;

import lombok.Getter;
import software_testing.text.abstract_classes.SmallSpaceObject;
import software_testing.text.interfaces.SpaceFlyable;

@Getter
public class Spaceship extends SmallSpaceObject implements SpaceFlyable {
    private StarSystem currentStarSystem;

    public Spaceship(StarSystem currentStarSystem, String name, double weight, double x, double y, double z, double maxOwnSpeed) {
        super(name, weight, x, y, z, maxOwnSpeed);
        this.currentStarSystem = currentStarSystem;
        this.currentStarSystem.addSpaceship(this);
    }

    @Override
    public void land(Planet planet) {
        System.out.println("Космический корабль с названием " + this.getName() + " приближается к планете " + planet.getName());
        System.out.println("Космический корабль с названием " + this.getName() + " пытается безопасно приземлиться");
        if (isAliveAfterLanding(planet)) {
            System.out.println("Космический корабль с названием " + this.getName() + " успешно приземлился на планету");
            System.out.println("Текущие координаты корабля: x = " + this.getX() + "; y = " + this.getY() + "; z = " + this.getZ());
        } else {
            System.out.println("Космический корабль с названием " + this.getName() + " разбился при приземлении");
        }
    }

    @Override
    public boolean flyToNewLocation(double x, double y, double z) {
        boolean isFlightPossible = true;
        for (Planet planet: this.currentStarSystem.getPlanetsList()) {
            double r = getOtherSpaceObjectDistance(planet);
            double newR = getOtherSpaceObjectNewDistance(planet,x,y,z);
            if (newR > r) {
                double m = planet.getWeight();
                double g = planet.getGravityConstant();
                double v2 = Math.sqrt((2*g*m)/r);
                if (this.getMaxOwnSpeed() < v2) {
                    System.out.println("Скорость корабля должна быть больше чем " + v2);
                    isFlightPossible = false;
                    break;
                }
            }
            if (newR < planet.getRadius()) {
                isFlightPossible = false;
                break;
            }
        }
        if (isFlightPossible) {
            System.out.println("Космический корабль с названием " + this.getName() + " успешно переместился на требуемое место");
            this.setX(x);
            this.setY(y);
            this.setZ(z);
            System.out.println("Текущие координаты корабля: x = " + this.getX() + "; y = " + this.getY() + "; z = " + this.getZ());
        } else {
            System.out.println("Космический корабль с названием " + this.getName() + " не смог совершить перелёт из-за воздействия гравитации");
        }
        return isFlightPossible;
    }
}
