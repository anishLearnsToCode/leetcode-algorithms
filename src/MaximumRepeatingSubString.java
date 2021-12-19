public class MaximumRepeatingSubString {
    public int maxRepeating(String sequence, String word) {
        int result = 0, index = 0;
        while (index < sequence.length()) {
            int matchIndex = sequence.indexOf(word, index);
            if (matchIndex == -1) break;
            int k = 0;
            for (int i = matchIndex + word.length() ; i < sequence.length() ; i += word.length(), k++) {
                if (!areEqual(sequence, word, i)) break;
            }
            result = Math.max(result, 1 + k);
            index = matchIndex + 1;
        }
        return result;
    }

    private boolean areEqual(String text, String pattern, int startIndex) {
        if (pattern.length() > text.length() - startIndex) return false;
        for (int i = startIndex ; i < text.length() && i - startIndex < pattern.length() ; i++) {
            if (text.charAt(i) != pattern.charAt(i - startIndex)) return false;
        }
        return true;
    }
}
