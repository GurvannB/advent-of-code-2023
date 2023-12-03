package fr.jetdev.day3;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EngineTest {
    private final String stringGeneration = "467..114..\n" +
            "...*......\n" +
            "..35..633.\n" +
            "......#...\n" +
            "617*......\n" +
            ".....+.58.\n" +
            "..592.....\n" +
            "......755.\n" +
            "...$.*....\n" +
            ".664.598..";

    @Test
    public void should_generate_engine_from_string() {
        Engine engine = new Engine();
        engine.addLine("467..114..");
        engine.addLine("...*......");
        engine.addLine("..35..633.");
        engine.addLine("......#...");
        engine.addLine("617*......");
        engine.addLine(".....+.58.");
        engine.addLine("..592.....");
        engine.addLine("......755.");
        engine.addLine("...$.*....");
        engine.addLine(".664.598..");

        assertEquals(engine, Engine.fromString(stringGeneration));
    }

    @Test
    public void should_add_line_to_engine() {
        Engine engine = new Engine();
        engine.addLine("Ligne");
        assertEquals(1, engine.getLines().size());
    }

    @Test
    public void initial_lines_of_engine_should_be_empty() {
        Engine engine = new Engine();
        assertEquals(0, engine.getLines().size());
    }

    @Test
    public void should_return_if_a_position_has_a_neighbor_symbol() {
        Engine engine = Engine.fromString(stringGeneration);
        assertTrue(engine.hasANeighborSymbol(0, 2));
        assertFalse(engine.hasANeighborSymbol(1, 0));
    }

    @Test
    public void should_return_all_numbers() {
        Engine engine = Engine.fromString(stringGeneration);
        ArrayList<PositionNumber> numbers = new ArrayList<>(List.of(
                new PositionNumber(0, 0, 467),
                new PositionNumber(0, 5, 114),
                new PositionNumber(2, 2, 35),
                new PositionNumber(2, 6, 633),
                new PositionNumber(4, 0, 617),
                new PositionNumber(5, 7, 58),
                new PositionNumber(6, 2, 592),
                new PositionNumber(7, 6, 755),
                new PositionNumber(9, 1, 664),
                new PositionNumber(9, 5, 598)
        ));
        assertEquals(numbers, engine.getAllNumbers());
    }

    @Test
    public void should_return_if_char_is_a_symbol() {
        assertFalse(Engine.isSymbol('.'));
        assertTrue(Engine.isSymbol('*'));
        assertTrue(Engine.isSymbol('$'));
        assertTrue(Engine.isSymbol('#'));
        assertTrue(Engine.isSymbol('='));
    }

    @Test
    public void should_return_a_character_for_a_position() {
        Engine engine = Engine.fromString(stringGeneration);
        assertEquals('4', (char) engine.get(0, 0));
        assertEquals('*', (char) engine.get(1, 3));
        assertEquals('$', (char) engine.get(8, 3));
        assertEquals('+', (char) engine.get(5, 5));
        assertEquals('#', (char) engine.get(3, 6));
    }

    @Test
    public void get_adjacent_to_symbol_numbers() {
        Engine engine = Engine.fromString(stringGeneration);
        ArrayList<Integer> numbers = new ArrayList(List.of(467, 35, 633, 617, 592, 755, 664, 598));
        assertEquals(numbers, engine.getAdjacentToSymbolNumbers());
    }

    @Test
    public void should_resolve() {
        Engine engine = Engine.fromString(stringGeneration);
        assertEquals(4361, engine.resolve());
    }
}