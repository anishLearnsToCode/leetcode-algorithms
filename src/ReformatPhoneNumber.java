import java.util.LinkedList;
import java.util.Queue;

public class ReformatPhoneNumber {
    public String reformatNumber(String number) {
        final Queue<Character> digits = getDigits(number);
        final StringBuilder result = new StringBuilder();
        int count = 3;
        while (!digits.isEmpty()) {
            if (digits.size() == 4 && count % 3 == 0) {
                result.append(count == 3 ? "" : '-').append(digits.poll()).append(digits.poll())
                        .append('-').append(digits.poll()).append(digits.poll());
                break;
            }
            result.append(count == 0 ? '-' : "").append(digits.poll());
            count = (count + 1) % 3;
        }
        return result.toString();
    }

    private Queue<Character> getDigits(String number) {
        final Queue<Character> digits = new LinkedList<>();
        for (int index = 0 ; index < number.length() ; index++) {
            if (Character.isDigit(number.charAt(index))) {
                digits.add(number.charAt(index));
            }
        }
        return digits;
    }
}
