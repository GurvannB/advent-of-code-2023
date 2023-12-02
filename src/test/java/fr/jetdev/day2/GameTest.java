package fr.jetdev.day2;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    public void should_initiate_game_without_leg() {
        Game game = new Game(1);
        assertEquals(0, game.getLegs().size());
    }

    @Test
    public void should_add_leg() {
        Leg leg = new Leg(0, 0, 0);
        Game game = new Game(1);
        game.addLeg(leg);
        assertEquals(1, game.getLegs().size());
        game.addLeg(new Leg(0, 0, 0));
        assertEquals(2, game.getLegs().size());
    }

    private Game gameWithLegs() {
        Leg leg1 = new Leg(10, 9, 14);
        Leg leg2 = new Leg(12, 2, 8);
        Leg leg3 = new Leg(1, 1, 23);

        Game game = new Game(1);
        game.addLeg(leg1);
        game.addLeg(leg2);
        game.addLeg(leg3);

        return game;
    }

    @Test
    public void should_return_max_blue_leg() {
        Game game = gameWithLegs();
        assertEquals(12, game.getMaxOfBlueCubes());
    }

    @Test
    public void should_return_max_red_leg() {
        Game game = gameWithLegs();
        assertEquals(9, game.getMaxOfRedCubes());
    }

    @Test
    public void should_return_max_green_leg() {
        Game game = gameWithLegs();
        assertEquals(23, game.getMaxOfGreenCubes());
    }

    @Test
    public void should_return_game_id() {
        Game game = new Game(2);
        assertEquals(2, game.getId());
    }

    @Test
    public void should_init_game_from_string() {
        String generation = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red";

        Game expected = new Game(4);
        expected.addLeg(new Leg(6, 3, 1));
        expected.addLeg(new Leg(0, 6, 3));
        expected.addLeg(new Leg(15, 14, 3));

        assertTrue(expected.equals(Game.fromString(generation)));
    }
}