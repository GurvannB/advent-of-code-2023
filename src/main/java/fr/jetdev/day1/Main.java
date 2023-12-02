package fr.jetdev.day1;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final String INPUT_FILE_NAME = "src/main/resources/day1/input.txt";

    public static void main(String[] args) throws IOException {
        partTwo();
    }

    public static void partOne() throws IOException {
        Scanner sc = new Scanner(new File(Main.INPUT_FILE_NAME));
        String line = "";
        int total = 0;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            int firstDigit = getFirstDigit(line);
            int lastDigit = getLastDigit(line);
            total += (firstDigit*10+lastDigit);
        }
        System.out.println(total);
    }

    public static void partTwo() throws IOException {
        Scanner sc = new Scanner(new File(Main.INPUT_FILE_NAME));
        String line = "";
        int total = 0;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String modifiedLine = stringNumbersToNumber(line);
            int firstDigit = getFirstDigit(modifiedLine);
            int lastDigit = getLastDigit(modifiedLine);
            total += (firstDigit*10+lastDigit);
        }
        System.out.println(total);
    }

    public static int getFirstDigit(String string) {
        int result = -1;
        int idx = 0;
        while (result == -1 && idx < string.length()) {
            char c = string.charAt(idx);
            if (c >= '0' && c <= '9') {
                result = c - '0';
            }
            idx++;
        }
        if (result == -1) throw new IllegalArgumentException();
        return result;
    }

    public static int getLastDigit(String string) {
        int result = -1;
        int idx = string.length()-1;
        while (result == -1 && idx >= 0) {
            char c = string.charAt(idx);
            if (c >= '0' && c <= '9') {
                result = c - '0';
            }
            idx--;
        }
        if (result == -1) throw new IllegalArgumentException();
        return result;
    }

    public static String stringNumbersToNumber(String string) {
        String result = string;
        Map<String, String> stringNumbers = Map.of(
                "one", "1",
                "two", "2",
                "three", "3",
                "four", "4",
                "five", "5",
                "six", "6",
                "seven", "7",
                "eight", "8",
                "nine", "9"
        );
        for (String numberKey: stringNumbers.keySet()) {
            result = result.replace(numberKey, numberKey+stringNumbers.get(numberKey)+numberKey);
        }

        return result;
    }
}
