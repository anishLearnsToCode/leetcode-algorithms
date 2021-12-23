public class NumberOfStringsThatAppearAsSubstringsInWord {
    public int numOfStrings(String[] patterns, String word) {
        int substrings = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                substrings++;
            }
        }
        return substrings;
    }
}
