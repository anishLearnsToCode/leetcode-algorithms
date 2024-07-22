// https://leetcode.com/problems/roman-to-integer
// T: O(|S|)
// S: O(1)

import java.util.Map;
import java.util.Set;

public class RomanToInteger {
    private static final Map<Character, Integer> ROMAN_NUMERALS = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    private static final Map<Character, Set<Character>> DECREMENT_ROMAN_NUMERALS = Map.of(
            'I', Set.of('V', 'X'),
            'X', Set.of('L', 'C'),
            'C', Set.of('D', 'M')
    );

    public int romanToInt(String s) {
        int number = 0;
        for (int i = 0 ; i < s.length() ; ) {
            final char c = s.charAt(i);
            if (DECREMENT_ROMAN_NUMERALS.containsKey(c)
                    && i + 1 < s.length()
                    && DECREMENT_ROMAN_NUMERALS.get(c).contains(s.charAt(i + 1))) {
                number += ROMAN_NUMERALS.get(s.charAt(i + 1)) - ROMAN_NUMERALS.get(c);
                i += 2;
            } else {
                number += ROMAN_NUMERALS.get(c);
                i++;
            }
        }
        return number;
    }
}
