package fr.jetdev.day3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionNumberTest {
    @Test
    public void should_instantiate_a_position_with_number_and_getters() {
        PositionNumber positionNumber = new PositionNumber(1, 2, 3);
        assertEquals(1, positionNumber.getRow());
        assertEquals(2, positionNumber.getCol());
        assertEquals(3, positionNumber.getNumber());
    }
}