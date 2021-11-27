public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int i = nextCharIndex(s, s.length()), j = nextCharIndex(t, t.length());
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) != t.charAt(j)) return false;
            i = nextCharIndex(s, i);
            j = nextCharIndex(t, j);
        }
        return i == -1 && j == -1;
    }

    private int nextCharIndex(String string, int currentIndex) {
        for (int buffer = 0 ; buffer >= 0 ; currentIndex--) {
            if (currentIndex == 0) {
                currentIndex = -1;
                break;
            }
            if (string.charAt(currentIndex - 1) == '#') buffer++;
            else buffer--;
        }
        return currentIndex;
    }
}
