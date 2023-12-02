package fr.jetdev.day2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.ToIntFunction;

public class Game {
    private int id;
    private List<Leg> legs;

    public Game(int id) {
        this.id = id;
        legs = new ArrayList<>();
    }

    public static Game fromString(String given) {
        String trimmedGiven = given.trim();
        String[] colonSplit = trimmedGiven.split(":");
        int id = Integer.parseInt(colonSplit[0].replace("Game ", ""));
        Game game = new Game(id);

        String[] legsSplit = colonSplit[1].split(";");
        for (String legString: legsSplit) {
            game.addLeg(Leg.fromString(legString));
        }
        return game;
    }

    public int getId() {
        return id;
    }

    public int getMaxOfBlueCubes() {
        return getMaxOf(Leg::getNbBlue).getNbBlue();
    }

    public int getMaxOfRedCubes() {
        return getMaxOf(Leg::getNbRed).getNbRed();
    }

    public int getMaxOfGreenCubes() {
        return getMaxOf(Leg::getNbGreen).getNbGreen();
    }

    private Leg getMaxOf(ToIntFunction<Leg> consumer) {
        Optional<Leg> optionalLeg = legs.stream().max(Comparator.comparingInt(consumer));
        if (optionalLeg.isPresent()) {
            return optionalLeg.get();
        }
        throw new NoSuchElementException();
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void addLeg(Leg leg) {
        legs.add(leg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && Objects.equals(legs, game.legs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, legs);
    }
}
