public class DIStringMatch {
    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];
        int current = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == 'I') result[i] = current++;
        }
        result[result.length - 1] = current++;
        for (int i = s.length() - 1 ; i >= 0 ; i--) {
            if (s.charAt(i) == 'D') result[i] = current++;
        }
        return result;
    }
}
