package fr.jetdev.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameResolver {
    private List<Game> games;

    public GameResolver() {
        games = new ArrayList<>();
    }

    public static GameResolver fromString(String given) {
        String trimmedGiven = given.trim();
        String[] gameStrings = trimmedGiven.split("\n");

        GameResolver gameResolver = new GameResolver();
        for (String gameString: gameStrings) {
            gameResolver.addGame(Game.fromString(gameString));
        }
        return gameResolver;
    }

    public int resolvePartOne(Leg configuration) {
        int total = 0;
        for (Game game: games) {
            if (
                game.getMaxOfBlueCubes() <= configuration.getNbBlue() &&
                game.getMaxOfRedCubes() <= configuration.getNbRed() &&
                game.getMaxOfGreenCubes() <= configuration.getNbGreen()
            ) {
                total += game.getId();
            }
        }
        return total;
    }

    public int resolvePartTwo() {
        return -1;
    }

    public List<Game> getGames() {
        return games;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResolver that = (GameResolver) o;
        return Objects.equals(games, that.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(games);
    }
}
