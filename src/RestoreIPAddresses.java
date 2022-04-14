import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(final String s) {
        final List<String> result = new ArrayList<>();
        restoreIpAddresses(s, result, new LinkedList<>(), 0);
        return result;
    }

    private void restoreIpAddresses(final String s, final List<String> result, LinkedList<Integer> numbers, int index) {
        if (numbers.size() == 4 && index == s.length()) {
            result.add(ipAddressFrom(numbers));
            return;
        }
        if (numbers.size() >= 4 || index == s.length()) {
            return;
        }
        for (int i = index + 1 ; i <= s.length() ; i++) {
            if (isValidIpAddressInteger(s, index, i)) {
                numbers.add(toNumber(s, index, i));
                restoreIpAddresses(s, result, numbers, i);
                numbers.removeLast();
            } else {
                break;
            }
        }
    }

    private String ipAddressFrom(LinkedList<Integer> numbers) {
        StringBuilder result = new StringBuilder();
        for (int number : numbers) {
            result.append(number).append('.');
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private boolean isValidIpAddressInteger(String s, int start, int end) {
        if (hasLeadingZeros(s, start, end)) return false;
        return toNumber(s, start, end) < 256;
    }

    private boolean hasLeadingZeros(String s, int start, int end) {
        return end - start > 1 && s.charAt(start) == '0';
    }

    private int toNumber(String s, int start, int end) {
        int val = 0;
        for (int index = start ; index < end ; index++) {
            val *= 10;
            val += s.charAt(index) - '0';
        }
        return val;
    }
}
