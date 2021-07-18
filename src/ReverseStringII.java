public class ReverseStringII {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        for (int index = 0 ; index < s.length() ; ) {
            for (int j = 0, reverseLength = Math.min(k, s.length() - index); j < reverseLength ; j++) {
                result.append(s.charAt(index + reverseLength - j - 1));
            }
            index += k;
            for (int j = 0 ; j < k && index + j < s.length() ; j++) {
                result.append(s.charAt(index + j));
            }
            index += k;
        }
        return result.toString();
    }
}
