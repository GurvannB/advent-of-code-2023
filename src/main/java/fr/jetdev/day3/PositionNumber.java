package fr.jetdev.day3;

public class PositionNumber {
    int row;
    int col;
    int number;

    public PositionNumber(int row, int col, int number) {
        this.row = row;
        this.col = col;
        this.number = number;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getNumber() {
        return number;
    }
}
