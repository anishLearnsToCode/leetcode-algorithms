// https://leetcode.com/problems/generate-parentheses
// T: O(Catalan-number(n)) or O(4^n/sqrt(n))
// S: O(Catalan-number(n)) or O(4^n/sqrt(n))

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParentheses {
    private static final Map<Integer, List<String>> VALID_PARENTHESES = new HashMap<>();

    static {
        VALID_PARENTHESES.put(0, List.of(""));
        VALID_PARENTHESES.put(1, List.of("()"));
        for (int i = 2 ; i <= 8 ; i++) {
            addValidParentheses(i);
        }
    }

    private static void addValidParentheses(int i) {
        final List<String> result = new ArrayList<>();
        addValidParentheses(i, result);
        VALID_PARENTHESES.put(i, result);
    }

    private static void addValidParentheses(int i, List<String> result) {
        for (int k = 0 ; k < i ; k++) {
            for (String s1 : VALID_PARENTHESES.get(i - k - 1)) {
                for (String s2 : VALID_PARENTHESES.get(k)) {
                    result.add("(" + s1 + ")" + s2);
                }
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        return VALID_PARENTHESES.get(n);
    }
}
