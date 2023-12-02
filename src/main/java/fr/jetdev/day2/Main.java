package fr.jetdev.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/day2/input.txt";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(Main.INPUT_FILE_NAME));
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while(line != null) {
            sb.append(line+"\n");
            line = reader.readLine();
        }
        GameResolver gameResolver = GameResolver.fromString(sb.toString());
        int answer = gameResolver.resolvePartOne(new Leg(14, 12, 13));
        System.out.println("The answer is : "+answer);
    }
}
