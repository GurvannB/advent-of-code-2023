package fr.jetdev.day3;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionNumber that = (PositionNumber) o;
        return row == that.row && col == that.col && number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, number);
    }
}
