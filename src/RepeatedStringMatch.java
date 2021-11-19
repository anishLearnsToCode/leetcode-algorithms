public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        Pair result = canBeRepeatedForSubstring(a, b);
        if (!result.canBeRepeated) return -1;
        return (int) Math.ceil(1 + (double) (a.length() + result.startIndex - b.length()) / b.length());
    }

    private Pair canBeRepeatedForSubstring(String a, String b) {
        boolean checking = false;
        char firstChar = a.charAt(0);
        int startIndex;
        for (int j = 0 ; j < b.length() ; j++) {
            if (firstChar == b.charAt(j)) {
                int i = 0;
                startIndex = j;
                for ( ; i < a.length() ; i++, j = (j + 1) % b.length()) {
                    if (a.charAt(i) != b.charAt(j)) {
                        break;
                    }
                }
                if (i == a.length()) return new Pair(startIndex, true);
            }
        }
        return new Pair(0, false);
    }

    private static class Pair {
        private final int startIndex;
        private final boolean canBeRepeated;

        Pair(final int startIndex, final boolean canBeRepeated) {
            this.startIndex = startIndex;
            this.canBeRepeated = canBeRepeated;
        }
    }
}
