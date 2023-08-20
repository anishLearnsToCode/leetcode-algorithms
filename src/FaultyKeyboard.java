// https://leetcode.com/problems/faulty-keyboard
// T: O(N^2)
// S: O(N)

public class FaultyKeyboard {
    public String finalString(String s) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++) {
            char character = s.charAt(i);
            if (character == 'i') {
                stringBuilder.reverse();
            } else {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }
}
