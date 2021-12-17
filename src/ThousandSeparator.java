import java.util.LinkedList;

public class ThousandSeparator {
    public String thousandSeparator(int n) {
        final LinkedList<Integer> list = getDigits(n);
        final StringBuilder result = new StringBuilder();
        for (int i = 3 ; !list.isEmpty() ; i = (i + 1) % 3) {
            if (i == 0) result.append('.');
            result.append(list.pop());
        }
        return result.reverse().toString();
    }

    private LinkedList<Integer> getDigits(int number) {
        final LinkedList<Integer> result = new LinkedList<>();
        if (number == 0) {
            result.add(0);
        }
        while (number > 0) {
            result.add(number % 10);
            number /= 10;
        }
        return result;
    }
}
