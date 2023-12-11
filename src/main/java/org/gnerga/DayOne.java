package org.gnerga;

import java.util.List;
import java.util.function.Function;

public class DayOne {
    static final int ZERO_IN_ASCII_CODE = 48;
    static final int NINE_IN_ASCII_CODE = 57;

    private static final Function<String, String> CONVERT_WORDS_TO_NUMBER =
        input -> input
                .replace("oneight","18")
                .replace("twone","21")
                .replace("threeight","38")
                .replace("fiveight","58")
                .replace("sevenine","79")
                .replace("eightwo","82")
                .replace("eighthree","83")
                .replace("nineight","98")
                .replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9")
                .replace("zero", "0");

    public static int run(List<String> inputData, boolean secondStar) {
        int result = 0;
        boolean isFirst = true;
        String number;
        String digit;

        for(String line : inputData) {
            number = "";
            digit = "";

            if (secondStar) {
                line = CONVERT_WORDS_TO_NUMBER.apply(line);
            }

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
        }
        return result;
    }

    public static boolean isNumber(char value) {
        return value >= ZERO_IN_ASCII_CODE
                && value <= NINE_IN_ASCII_CODE;
    }
}
