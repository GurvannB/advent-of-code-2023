package fr.jetdev.day2;

import java.util.Objects;

public class Leg {
    private int nbBlue;
    private int nbRed;
    private int nbGreen;

    public Leg(int nbBlue, int nbRed, int nbGreen) {
        this.nbBlue = nbBlue;
        this.nbRed = nbRed;
        this.nbGreen = nbGreen;
    }

    public static Leg fromString(String given) {
        String trimmedGiven = given.trim();
        int nbBlue = 0;
        int nbRed = 0;
        int nbGreen = 0;

        String[] values = given.split(",");
        for (String value: values) {
            if (value.contains("blue")) {
                nbBlue = Integer.parseInt(value.trim().replace("blue", "").trim());
            } else if (value.contains("red")) {
                nbRed = Integer.parseInt(value.trim().replace("red", "").trim());
            } else if (value.contains("green")) {
                nbGreen = Integer.parseInt(value.trim().replace("green", "").trim());
            }
        }
        return new Leg(nbBlue, nbRed, nbGreen);
    }

    public int getNbBlue() {
        return nbBlue;
    }

    public int getNbRed() {
        return nbRed;
    }

    public int getNbGreen() {
        return nbGreen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leg leg = (Leg) o;
        return nbBlue == leg.nbBlue && nbRed == leg.nbRed && nbGreen == leg.nbGreen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbBlue, nbRed, nbGreen);
    }
}
