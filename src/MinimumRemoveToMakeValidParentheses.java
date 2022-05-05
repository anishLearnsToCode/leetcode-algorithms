// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses
// T: O(n)
// S: O(n)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    private static final record OpeningBrace(int index) { }

    public String minRemoveToMakeValid(String s) {
        final Stack<OpeningBrace> stack = new Stack<>();
        final List<Integer> extraClosingBraceIndices = new ArrayList<>();
        char c;
        for (int i = 0 ; i < s.length() ; i++) {
            c = s.charAt(i);
            if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else extraClosingBraceIndices.add(i);
            } else if (c == '(') stack.push(new OpeningBrace(i));
        }
        final Set<Integer> errorIndices = compileErrorIndicesFrom(extraClosingBraceIndices, stack);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length() ; i++) {
            if (!errorIndices.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    private Set<Integer> compileErrorIndicesFrom(List<Integer> wrongClosingBraces, Stack<OpeningBrace> openingBraces) {
        Set<Integer> result = new HashSet<>();
        while (!openingBraces.isEmpty()) {
            result.add(openingBraces.pop().index);
        }
        result.addAll(wrongClosingBraces);
        return result;
    }
}
