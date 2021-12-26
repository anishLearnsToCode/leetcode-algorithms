// https://leetcode.com/problems/integer-to-roman
// T: O(log n)
// S: O(log n)

import java.util.Map;

public class IntegerToRoman {
    private final static int ONE = 1;
    private final static int FIVE = 5;
    private final static int TEN = 10;

    private final static Map<Integer, String> ONES_PLACE_ROMAN_CHARS = Map.ofEntries(
            Map.entry(ONE, "I"),
            Map.entry(FIVE, "V"),
            Map.entry(TEN, "X")
    );

    private final static Map<Integer, String> TENS_PLACE_ROMAN_CHARS = Map.ofEntries(
            Map.entry(ONE, "X"),
            Map.entry(FIVE, "L"),
            Map.entry(TEN, "C")
    );

    private final static Map<Integer, String> HUNDREDS_PLACE_ROMAN_CHARS = Map.ofEntries(
            Map.entry(ONE, "C"),
            Map.entry(FIVE, "D"),
            Map.entry(TEN, "M")
    );

    public String intToRoman(int num) {
        final StringBuilder result = new StringBuilder();
        for (int place = 1000 ; num > 0 ; place /= 10) {
            result.append(toRoman(num / place, place));
            num -= (num / place) * place;
        }
        return result.toString();
    }

    private String toRoman(int digit, int place) {
        return switch (place) {
            case 1 -> toRomanFromPlace(digit, ONES_PLACE_ROMAN_CHARS);
            case 10 -> toRomanFromPlace(digit, TENS_PLACE_ROMAN_CHARS);
            case 100 -> toRomanFromPlace(digit, HUNDREDS_PLACE_ROMAN_CHARS);
            case 1000 -> thousandsPlaceToRoman(digit);
            default -> "";
        };
    }

    private String toRomanFromPlace(int digit, Map<Integer, String> romanChars) {
        return switch (digit) {
            case 1, 2, 3 -> romanChars.get(ONE).repeat(digit);
            case 4 -> romanChars.get(ONE) + romanChars.get(FIVE);
            case 5, 6, 7, 8 -> romanChars.get(FIVE) + romanChars.get(ONE).repeat(digit - 1);
            case 9 -> romanChars.get(ONE) + romanChars.get(TEN);
            default -> "";
        };
    }

    private String thousandsPlaceToRoman(int digit) {
        return "M".repeat(digit);
    }
}
