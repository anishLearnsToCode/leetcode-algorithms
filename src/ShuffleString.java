public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        final char[] result = new char[indices.length];
        for (int i = 0 ; i < s.length() ; i++) {
            result[indices[i]] = s.charAt(i);
        }
        return String.valueOf(result);
    }
}
