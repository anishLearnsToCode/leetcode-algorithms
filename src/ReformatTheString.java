import java.util.LinkedList;
import java.util.Queue;

public class ReformatTheString {
    public String reformat(String s) {
        Queue<Character> digits = new LinkedList<>();
        Queue<Character> alphabets = new LinkedList<>();
        for (int index = 0 ; index < s.length() ; index++) {
            if (Character.isAlphabetic(s.charAt(index))) {
                alphabets.add(s.charAt(index));
            } else digits.add(s.charAt(index));
        }
        if (Math.abs(digits.size() - alphabets.size()) > 1) return "";
        StringBuilder result = new StringBuilder();
        result.append(alphabets.size() > digits.size() ? alphabets.poll() : "");
        while (!digits.isEmpty() && !alphabets.isEmpty()) {
            result.append(digits.poll()).append(alphabets.poll());
        }
        result.append(!digits.isEmpty() ? digits.poll() : "");
        return result.toString();
    }
}
