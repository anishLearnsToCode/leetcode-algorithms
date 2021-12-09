public class IncreasingDecreasingString {
    public String sortString(String s) {
        final int[] frequency = getFrequency(s);
        final StringBuilder result = new StringBuilder();
        while (result.length() < s.length()) {
            for (int i = 0 ; i < frequency.length ; i++) {
                if (frequency[i] > 0) {
                    result.append((char) ('a' + i));
                    frequency[i]--;
                }
            }
            for (int i = frequency.length - 1 ; i >= 0 ; i--) {
                if (frequency[i] > 0) {
                    result.append((char) ('a' + i));
                    frequency[i]--;
                }
            }
        }
        return result.toString();
    }

    private int[] getFrequency(String string) {
        final int[] frequencies = new int[26];
        for (int i = 0 ; i < string.length() ; i++) {
            frequencies[string.charAt(i) - 'a']++;
        }
        return frequencies;
    }
}
