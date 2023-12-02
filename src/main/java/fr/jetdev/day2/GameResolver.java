package fr.jetdev.day2;

import java.util.ArrayList;
import java.util.List;

public class GameResolver {
    private List<Game> games;

    public GameResolver() {
        games = new ArrayList<>();
    }

    public static GameResolver fromString(String given) {
        return new GameResolver();
    }

    public int resolve(Leg configuration) {
        return -1;
    }

    public List<Game> getGames() {
        return games;
    }

    public void addGame(Game game) {
    }
}
