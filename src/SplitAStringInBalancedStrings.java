public class SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int balancedSubStrings = 0;
        for (int i = 0, current = 0 ; i < s.length() ; i++) {
            current += s.charAt(i) == 'L' ? -1 : 1;
            if (current == 0) balancedSubStrings++;
        }
        return balancedSubStrings;
    }
}
