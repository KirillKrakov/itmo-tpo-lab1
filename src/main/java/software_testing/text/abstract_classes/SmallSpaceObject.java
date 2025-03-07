package software_testing.text.abstract_classes;

import lombok.Getter;
import lombok.Setter;
import software_testing.text.characters.Planet;

@Getter
public abstract class SmallSpaceObject extends SpaceObject{
    @Setter
    private double maxOwnSpeed;
    private boolean isAlive;

    public SmallSpaceObject(String name, double weight, double x, double y, double z, double maxOwnSpeed) {
        super(name, weight, x, y, z);
        this.maxOwnSpeed = maxOwnSpeed;
        this.isAlive = true;
        checkForIncorrectStates();
    }

    public boolean isAliveAfterLanding(Planet planet) {
        double h = getOtherSpaceObjectDistance(planet);
        double g = planet.getGravityConstant();
        double landingSpeed = Math.sqrt(2*g*h);
        if (landingSpeed > maxOwnSpeed) {
            System.out.println("Максимальная скорость объекта должна быть больше " + landingSpeed);
            isAlive = false;
        } else {
            planet.addObjectOnPlanet(this);
            setPlanetCoordinates(planet);
        }
        return isAlive;
    }

    public void setPlanetCoordinates(Planet planet) {
        double newX = planet.getX() > this.getX() ? planet.getX() - planet.getRadius() : planet.getX() + planet.getRadius();
        double newY = planet.getY() > this.getY() ? planet.getY() - planet.getRadius() : planet.getY() + planet.getRadius();
        double newZ = planet.getZ() > this.getZ() ? planet.getZ() - planet.getRadius() : planet.getZ() + planet.getRadius();
        this.setX(newX);
        this.setY(newY);
        this.setZ(newZ);
    }

    public void land(Planet planet) {}

    public void checkForIncorrectStates() {
        if (this.getName().isEmpty() || this.getWeight() == Double.NaN || this.getWeight() <= 0 || this.getX() == Double.NaN || this.getY() == Double.NaN ||
                this.getZ() == Double.NaN || this.getMaxOwnSpeed() == Double.NaN || this.getMaxOwnSpeed() < 0) {
            throw new IllegalStateException("Incorrect input arguments");
        }
    }
}
