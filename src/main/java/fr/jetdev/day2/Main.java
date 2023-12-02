package fr.jetdev.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String PART_ONE_INPUT_FILE_NAME = "src/main/resources/day2/input.txt";
    private static final String PART_TWO_INPUT_FILE_NAME = "src/main/resources/day2/input.txt";
    public static void main(String[] args) throws IOException {
        resolvePartOne();
        resolvePartTwo();
    }

    public static void resolvePartOne() throws IOException {
        String inputFile = getInputFileContent(PART_ONE_INPUT_FILE_NAME);
        GameResolver gameResolver = GameResolver.fromString(inputFile);
        int answer = gameResolver.resolvePartOne(new Leg(14, 12, 13));
        System.out.println("The answer for the part one is : "+answer);
    }

    public static void resolvePartTwo() throws IOException {
        String inputFile = getInputFileContent(Main.PART_TWO_INPUT_FILE_NAME);
        GameResolver gameResolver = GameResolver.fromString(inputFile);
        int answer = gameResolver.resolvePartTwo();
        System.out.println("The answer for the part two is : "+answer);
    }

    public static String getInputFileContent(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while(line != null) {
            sb.append(line+"\n");
            line = reader.readLine();
        }
        return sb.toString();
    }
}
