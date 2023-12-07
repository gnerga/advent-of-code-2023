package org.gnerga;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    static final int ZERO_IN_ASCII_CODE = 48;
    static final int NINE_IN_ASCII_CODE = 57;
    public static void main(String[] args) {
        List<String> inputData = readInputFile("src/main/resources/input.txt");

        int result = 0;
        boolean isFirst = true;
        String number;
        String digit;

        for(String line : inputData) {
            number = "";
            digit = "";
            for (char value : line.toCharArray()) {
                if (isNumber(value)) {
                    digit = String.valueOf(value);
                    if(isFirst) {
                        number = digit;
                        isFirst = false;
                    }
                }
            }
            number += digit;
            result += Integer.parseInt(number);
            isFirst = true;
            System.out.println(number);
        }
        System.out.println("-----------------");
        System.out.println("Result: " + result);
    }

    public static boolean isNumber(char value) {
        return value >= ZERO_IN_ASCII_CODE
                && value <= NINE_IN_ASCII_CODE;
    }

    public static List<String> readInputFile(String path) {
        List<String> allLines = null;
        try {
            allLines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allLines;
    }
}