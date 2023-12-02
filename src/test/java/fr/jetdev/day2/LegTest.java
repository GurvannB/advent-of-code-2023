package fr.jetdev.day2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LegTest {
    @Test
    public void should_return_number_of_cubes() {
        Leg leg = new Leg(5, 9, 7);
        assertEquals(5, leg.getNbBlue());
        assertEquals(9, leg.getNbRed());
        assertEquals(7, leg.getNbGreen());
    }

    @Test
    public void should_return_a_string_generated_leg() {
        String generation = "17 red, 9 blue";
        Leg leg = Leg.fromString(generation);
        Leg expected = new Leg(9, 17, 0);
        assertTrue(expected.equals(leg));
    }

    @Test
    public void should_return_power_of_leg() {
        assertEquals(36, new Leg(3, 4, 3).getPower());
        assertEquals(1120, new Leg(8, 20, 7).getPower());
    }
}