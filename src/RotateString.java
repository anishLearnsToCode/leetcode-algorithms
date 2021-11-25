public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal) || s.length() == 0) return true;
        return patternExists(s + s, goal);
    }

    private boolean patternExists(String string, String pattern) {
        return kmpIndex(string, pattern) != -1;
    }

    private int kmpIndex(String string, String pattern) {
        int[] patternPrefix = patternPrefixArray(pattern);
        for (int t = 0, p = 0 ; t < string.length() && p < pattern.length() ; ) {
            if (string.charAt(t) == pattern.charAt(p)) {
                if (p == pattern.length() - 1) return t - p;
                p++;
                t++;
            } else if (p != 0) {
                p = patternPrefix[p - 1];
            } else {
                t++;
            }
        }
        return -1;
    }

    private int[] patternPrefixArray(String pattern) {
        int[] patternPrefix = new int[pattern.length()];
        for (int j = 0, i = 1 ; i  < pattern.length() && j < pattern.length() ; ) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                patternPrefix[i++] = j++ + 1;
            } else if (j == 0) {
                patternPrefix[i++] = 0;
            } else {
                j = patternPrefix[j - 1];
            }
        }
        return patternPrefix;
    }
}
