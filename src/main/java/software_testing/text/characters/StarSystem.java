package software_testing.text.characters;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class StarSystem {
    private String name;
    private ArrayList<Planet> planetsList;
    private ArrayList<Spaceship> spaceshipsList;

    public StarSystem(String name) {
        this.name = name;
        this.planetsList = new ArrayList<>();
        this.spaceshipsList = new ArrayList<>();
    }

    public void addSpaceship(Spaceship spaceship) {
        System.out.println("В звёздной системе " + this.name + " появился звёздный корабль под названием " + spaceship.getName());
        spaceshipsList.add(spaceship);
    }

    public void addPlanet(Planet planet) {
        System.out.println("В звёздной системе " + this.name + " существует планета " + planet.getName());
        planetsList.add(planet);
    }
}
