package fr.jetdev.day3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Engine {
    List<String> engine;

    public Engine() {
        this.engine = new ArrayList<>();
    }

    public static Engine fromString(String generationString) {
        Engine engine = new Engine();
        String line = "";
        char[] chars = generationString.toCharArray();
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == '\n') {
                engine.addLine(line);
                line = "";
            } else if (i == chars.length - 1) {
                line+= chars[i];
                engine.addLine(line);
                line = "";
            } else {
                line += chars[i];
            }
        }
        return engine;
    }

    public void addLine(String line) {
        engine.add(line);
    }

    public List<String> getLines() {
        return engine;
    }

    public boolean hasANeighborSymbol(int row, int col) {
        boolean result = false;
        for (int rowIdx=row-1; rowIdx<=row+1; rowIdx++) {
            for (int colIdx=col-1; colIdx<=col+1; colIdx++) {
                Character symbol = get(rowIdx, colIdx);
                if (symbol != null) {
                    result = result || isSymbol(symbol);
                }
            }
        }
        return result;
    }

    public Character get(int row, int col) {
        if (row < 0 || row >= engine.size()) return null;
        String rowString = engine.get(row);
        if (rowString == null) return null;
        if (col < 0 || rowString.length() <= col) return null;
        return rowString.charAt(col);
    }

    public List<PositionNumber> getAllNumbers() {
        List<PositionNumber> numbers = new ArrayList<>();
        for (int row=0; row<engine.size(); row++) {
            String number = "";
            char[] chars = engine.get(row).toCharArray();
            for (int col=0; col<engine.get(row).length(); col++) {
                if (chars[col] >= '0' && chars[col] <= '9') {
                    number += chars[col];
                } else {
                    if (!number.isEmpty()) {
                        numbers.add(
                                new PositionNumber(
                                        row,
                                        col- number.length(),
                                        Integer.parseInt(number))
                        );
                        number = "";
                    }
                }
            }
        }
        return numbers;
    }

    public static boolean isSymbol(char c) {
        List<Character> notAccepted = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.');
        return !notAccepted.contains(c);
    }

    public int resolve() {
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine1 = (Engine) o;
        return this.engine.equals(((Engine) o).getLines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine);
    }

    public List<Integer> getAdjacentToSymbolNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (PositionNumber positionNumber: getAllNumbers()) {
            boolean hasANeighbor = false;
            int colDelta = 0;
            while (!hasANeighbor && colDelta < String.valueOf(positionNumber.getNumber()).length()) {
                if (hasANeighborSymbol(positionNumber.getRow(), positionNumber.getCol()+colDelta)) {
                    hasANeighbor = true;
                }
                colDelta++;
            }
            if (hasANeighbor) numbers.add(positionNumber.getNumber());
        }
        return numbers;
    }
}
