public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder(), buffer = new StringBuilder();
        for (int index = 0 ; index < s.length() ; index++) {
            if (s.charAt(index) == ' ') {
                result.append(result.length() == 0 ? "" : ' ').append(buffer.reverse());
                buffer = new StringBuilder();
            } else {
                buffer.append(s.charAt(index));
            }
        }
        result.append(result.length() == 0 ? "" : ' ').append(buffer.reverse());
        return result.toString();
    }
}
