package fr.jetdev.day2;

public class Leg {
    private int nbBlue;
    private int nbRed;
    private int nbGreen;

    public Leg(int nbBlue, int nbRed, int nbGreen) {
        this.nbBlue = nbBlue;
        this.nbRed = nbRed;
        this.nbGreen = nbGreen;
    }

    public static Leg fromString(String leg) {
        return new Leg(0, 0, 0);
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
}
