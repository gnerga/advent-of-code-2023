package org.gnerga;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static final String INPUT_PATH = "src/main/resources/input.txt";
    private static final String TEST_PATH = "src/main/resources/test.txt";
    private static final String TEST_2_PATH = "src/main/resources/test2.txt";
    public static void main(String[] args) {
        List<String> inputData = readInputFile(INPUT_PATH);

        System.out.println("Result: " + DayOne.run(inputData, true));
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