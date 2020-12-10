public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String pattern) {
        for (int len = 1 ; len <= pattern.length() / 2 ; len++) {
            if (pattern.length() % len == 0) {
                String substring = pattern.substring(0, len);
                if (patternComposedOf(pattern, substring)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean patternComposedOf(String pattern, String subString) {
        for (int i = 0 ; i < pattern.length() / subString.length() ; i++) {
            for (int j = 0 ; j < subString.length() ; j++) {
                if (subString.charAt(j) != pattern.charAt(i * subString.length() + j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
