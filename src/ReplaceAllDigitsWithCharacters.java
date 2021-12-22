public class ReplaceAllDigitsWithCharacters {
    public String replaceDigits(String s) {
        final StringBuilder result = new StringBuilder();
        for (int i = 1 ; i < s.length() ; i += 2) {
            result.append(s.charAt(i - 1)).append(shift(s.charAt(i - 1), s.charAt(i) - '0'));
        }
        if (s.length() % 2 == 1) {
            result.append(s.charAt(s.length() - 1));
        }
        return result.toString();
    }

    private char shift(char c, int shiftAmount) {
        return (char) (c + shiftAmount);
    }
}
