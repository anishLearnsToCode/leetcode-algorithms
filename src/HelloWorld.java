public class HelloWorld {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0 ; i < haystack.length() ; i++) {
            if (needle.charAt(0) == haystack.charAt(i) && containsAt(haystack, needle, i)) {
                return i;
            }
        }

        return -1;
    }

    private static boolean containsAt(String haystack, String needle, int i) {
        if (needle.length() > haystack.length() - i) {
            return false;
        }
        for (int index = i + 1 ; index < haystack.length() && index - i < needle.length() ; index++) {
            if (needle.charAt(index - i) != haystack.charAt(index)) {
                return false;
            }
        }
        return true;
    }
}
