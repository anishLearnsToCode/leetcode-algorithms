public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int nestingDepth = 0, maximumNestingDepth = 0;
        for (int index = 0 ; index < s.length() ; index++) {
            if (s.charAt(index) == '(') nestingDepth++;
            else if (s.charAt(index) == ')') nestingDepth--;
            maximumNestingDepth = Math.max(nestingDepth, maximumNestingDepth);
        }
        return maximumNestingDepth;
    }
}
