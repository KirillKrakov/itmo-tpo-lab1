package software_testing.text;

import software_testing.text.characters.Planet;
import software_testing.text.characters.PetuniaPot;
import software_testing.text.characters.Spaceship;
import software_testing.text.characters.StarSystem;
import software_testing.text.characters.Whale;

public class Main {
    public static void main(String[] args) {
        StarSystem starSystem = new StarSystem("Solar System");
        Whale whale = new Whale("Poor Whale", 41000,20,20,20,0);
        PetuniaPot petuniaPot = new PetuniaPot("Pot with Petunia",0.2, 30,30,30,0);
        Spaceship spaceship = new Spaceship(starSystem,"Golden Heart",100000,10,8,9,20);
        Planet planet = new Planet(starSystem, "Magrathea", 600000000, 4,10,6,10,1);
        whale.addThought("о! интеpесное ощущение, пpавда, что это такое? Что-то вpоде... пустоты, и какого-то покалывания в моем... моем... похоже, надо начинать давать вещам имена, если я хочу хоть как-то пpобиться в том, что я pади того, что я наpекаю пpостотой, назову миpом, поэтому назовем это моим животом. Хоpошо.");
        whale.addThought("Эге-гей! - жизнь чудесна, я столько всего встpечу, столько всего узнаю, у меня голова кpужится от пpедвкушения... Или от ветpа?");
        petuniaPot.addThought("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        whale.land(planet);
        petuniaPot.land(planet);
        spaceship.land(planet);
        spaceship.flyToNewLocation(10,8,9);
        spaceship.setMaxOwnSpeed(84000);
        spaceship.flyToNewLocation(10,8,9);
    }
}
