// https://leetcode.com/problems/strobogrammatic-number
// T: O(N)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

// Strobogrammatic digits: 0, 1, 8
// Strobogrammatic interchangeable digits: 6 --> 9, 9 --> 6
public class StrobogrammaticNumber {
    private static final Map<Character, Character> STROBOGRAMMATIC_MIRROR = new HashMap<>() {{
        put('0', '0');
        put('1', '1');
        put('6', '9');
        put('8', '8');
        put('9', '6');
    }};

    public boolean isStrobogrammatic(String number) {
        for (int i = 0 ; i < number.length() ; i++) {
            final char digit = number.charAt(i);
            if (!STROBOGRAMMATIC_MIRROR.containsKey(digit)
                    || STROBOGRAMMATIC_MIRROR.get(digit) != number.charAt(number.length() - 1 - i)
            ) {
                return false;
            }
        }
        return true;
    }
}
