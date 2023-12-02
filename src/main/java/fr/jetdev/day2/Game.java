package fr.jetdev.day2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.ToIntFunction;

public class Game {
    private int id;
    private List<Leg> legs;

    public Game(int id) {
        this.id = id;
        legs = new ArrayList<>();
    }

    public static Game fromString(String game) {
        return new Game(0);
    }

    public int getId() {
        return id;
    }

    public Leg getMaxOfBlueCubesLeg() {
        return getMaxOf(Leg::getNbBlue);
    }

    public Leg getMaxOfRedCubesLeg() {
        return getMaxOf(Leg::getNbRed);
    }

    public Leg getMaxOfGreenCubesLeg() {
        return getMaxOf(Leg::getNbGreen);
    }

    private Leg getMaxOf(ToIntFunction<Leg> consumer) {
        return null;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void addLeg(Leg leg) {
    }
}
