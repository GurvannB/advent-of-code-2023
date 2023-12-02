package fr.jetdev.day2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameResolverTest {
    private final String testGeneration = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" +
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" +
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" +
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";

    private final GameResolver testGameResolver = GameResolver.fromString(testGeneration);

    @Test
    public void should_init_game_resolver_with_empty_games() {
        GameResolver gameResolver = new GameResolver();
        assertEquals(0, gameResolver.getGames().size());
    }

    @Test
    public void should_be_able_to_add_a_game() {
        GameResolver gameResolver = new GameResolver();
        gameResolver.addGame(new Game(1));
        assertEquals(1, gameResolver.getGames().size());
    }

    private GameResolver getGameResolver() {
        GameResolver gameResolver = new GameResolver();

        Game game1 = new Game(1);
        game1.addLeg(new Leg(3, 4, 0));
        game1.addLeg(new Leg(6, 1, 2));
        game1.addLeg(new Leg(0, 0, 2));
        gameResolver.addGame(game1);

        Game game2 = new Game(2);
        game2.addLeg(new Leg(1, 0, 2));
        game2.addLeg(new Leg(4, 1, 3));
        game2.addLeg(new Leg(1, 0, 1));
        gameResolver.addGame(game2);

        Game game3 = new Game(3);
        game3.addLeg(new Leg(6, 20, 8));
        game3.addLeg(new Leg(5, 4, 13));
        game3.addLeg(new Leg(0, 1, 5));
        gameResolver.addGame(game3);

        Game game4 = new Game(4);
        game4.addLeg(new Leg(6, 3, 1));
        game4.addLeg(new Leg(0, 6, 3));
        game4.addLeg(new Leg(15, 14, 3));
        gameResolver.addGame(game4);

        Game game5 = new Game(5);
        game5.addLeg(new Leg(1, 6, 3));
        game5.addLeg(new Leg(2, 1, 2));
        gameResolver.addGame(game5);

        return gameResolver;
    }

    @Test
    public void should_generate_game_resolver_by_string() {
        GameResolver gameResolver = getGameResolver();
        assertEquals(gameResolver, GameResolver.fromString(testGeneration));
    }

    @Test
    public void should_resolve_game_for_part_one() {
        assertEquals(8, testGameResolver.resolvePartOne(new Leg(14, 12, 13)));
    }

    @Test
    public void should_resolve_game_for_part_two() {
        assertEquals(2286, testGameResolver.resolvePartTwo());
    }
}