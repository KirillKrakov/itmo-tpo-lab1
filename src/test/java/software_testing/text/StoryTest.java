package software_testing.text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import software_testing.text.characters.*;

import static org.junit.jupiter.api.Assertions.*;

public class StoryTest {
    private StarSystem starSystem = new StarSystem("Test system");
    private Planet planet = new Planet(starSystem, "Magrathea", 600000000, 4,10,6,10,1);
    private Spaceship s1 = new Spaceship(starSystem,"Golden Heart",100000,10,8,9,12);
    private Spaceship s2 = new Spaceship(starSystem,"Blue Eye",1000,-2,12,3,11);
    Whale whale = new Whale("Poor Whale", 41000,20,20,20,0);
    PetuniaPot pot = new PetuniaPot("Pot with Petunia",0.2, 30,30,30,0);

    @Test
    public void testThinkable() {
        whale.addThought("хочу кушать");
        whale.addThought("хочу спать");
        pot.addThought("хочу чтобы меня полили");
        assertEquals(2, whale.getWhaleThoughts().size(), "Всего должно быть 2 мысли у кита");
        assertTrue(pot.getPotThoughts().contains("хочу чтобы меня полили"), "Среди мыслей горшка должна быть \"хочу чтобы меня полили\"");
    }

    @Test
    public void testLanding() {
        assertEquals(7.0, s1.getOtherSpaceObjectDistance(planet), "Расстояние между первым кораблём и планетом должно быть равно 7");
        assertTrue(s1.isAliveAfterLanding(planet), "sqrt(2  * 10 * 7) = sqrt (140) < 12");
        assertEquals(5,s1.getX());
        assertEquals(9, s1.getY());
        assertEquals(7, s1.getZ());
        assertEquals(7.0, s2.getOtherSpaceObjectDistance(planet), "Расстояние между вторым кораблём и планетом должно быть равно 7");
        assertFalse(s2.isAliveAfterLanding(planet), "sqrt(2  * 10 * 7) = sqrt (140) > 11");
    }

    @Test
    public void testMovable() {
        assertFalse(s1.flyToNewLocation(-4,-4,-4), "Скорость корабля должна быть больше чем 41403.933560541256");
        assertTrue(s2.flyToNewLocation(-2, 10, 3), "Радиус стал меньше, увеличение скорости до 2 космической не нужно");
        s1.setMaxOwnSpeed(42000);
        assertTrue(s1.flyToNewLocation(-4,-4,-4), "После увеличесния скорости смогли прилететь");
    }

    @Test
    public void testCorrectStates() {
        assertEquals(600000000, planet.getWeight());
        assertEquals(10, s1.getX());
        assertEquals(11, s2.getMaxOwnSpeed());
        assertEquals("Poor Whale", whale.getName());
        assertEquals(30, pot.getY());
    }

    @Test
    public void testIncorrectStates() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            Whale whale2 = new Whale("Poor Whale", -41000,20,20,20,0);
            Planet planet2 = new Planet(starSystem, "Earth", 300000000, -6,5,5,-20,2);
        });
    }
}
