public class CountBinarySubstrings {
    public int countBinarySubstrings(String string) {
        int binarySubStrings = 0, prev = 0, current = 1;
        for (int index = 1 ; index < string.length() ; index++) {
            if (string.charAt(index - 1) != string.charAt(index)) {
                binarySubStrings += Math.min(prev, current);
                prev = current;
                current = 1;
            } else current++;
        }
        return binarySubStrings + Math.min(prev, current);
    }
}
