package software_testing.text.characters;

import lombok.Getter;
import software_testing.text.abstract_classes.SmallSpaceObject;
import software_testing.text.abstract_classes.SpaceObject;

import java.util.ArrayList;

@Getter
public class Planet extends SpaceObject {
    private double gravityConstant;
    private ArrayList<SmallSpaceObject> objectsOnPlanet;
    private StarSystem currentStarSystem;
    private double radius;

    public Planet(StarSystem currentStarSystem, String name, double weight, double x, double y, double z, double gravityConstant, double radius) {
        super(name, weight, x, y, z);
        this.gravityConstant = gravityConstant;
        this.radius = radius;
        this.objectsOnPlanet = new ArrayList<>();
        this.currentStarSystem = currentStarSystem;
        this.currentStarSystem.addPlanet(this);
        checkForIncorrectStates();
    }

    public void addObjectOnPlanet(SmallSpaceObject smallSpaceObject) {
        System.out.println("На планете " + this.getName() + " появился новый объект: " + smallSpaceObject.getName());
        objectsOnPlanet.add(smallSpaceObject);
    }

    public void AllObjectOnPlanetList() {
        System.out.println("Список объектов на планете " + this.getName() + " :");
        for (SmallSpaceObject smallSpaceObject : objectsOnPlanet) {
            System.out.println("> " + smallSpaceObject.getName());
        }
    }

    public void checkForIncorrectStates() {
        if (this.getName().isEmpty() || this.getWeight() == Double.NaN || this.getWeight() <= 0 || this.getX() == Double.NaN || this.getY() == Double.NaN ||
                this.getZ() == Double.NaN || this.getGravityConstant() == Double.NaN || this.getGravityConstant() < 0 || this.getRadius() == Double.NaN || this.getRadius() <= 0) {
            throw new IllegalStateException("Incorrect input arguments");
        }
    }
}
