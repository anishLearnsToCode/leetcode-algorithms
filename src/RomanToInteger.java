// https://leetcode.com/problems/roman-to-integer/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInteger {
    private static final Map<Character, Integer> romanNumerals = new HashMap<>();

    static {
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String roman = scanner.next();
        System.out.println(romanToInt(roman));
    }

    private static int romanToInt(String string) {
        int value = 0;
        for (int index = 0 ; index < string.length() ; index++) {
            if (index < string.length() - 1 && value(string.charAt(index)) < value(string.charAt(index + 1))) {
                value -= value(string.charAt(index));
            } else {
                value += value(string.charAt(index));
            }
        }
        return value;
    }

    private static int value(char character) {
        return romanNumerals.get(character);
    }
}
