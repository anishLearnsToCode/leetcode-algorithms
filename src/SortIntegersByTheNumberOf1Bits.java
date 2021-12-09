import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] array) {
        List<Integer> sorted = Arrays.stream(array).boxed().sorted((a, b) -> {
            final int setBits1 = setBits(a), setBits2 = setBits(b);
            if (setBits1 == setBits2) return Integer.compare(a, b);
            return Integer.compare(setBits1, setBits2);
        }).collect(Collectors.toList());
        return toArray(sorted);
    }

    private int[] toArray(List<Integer> array) {
        final int[] result = new int[array.size()];
        for (int index = 0 ; index < result.length ; index++) {
            result[index] = array.get(index);
        }
        return result;
    }

    private int setBits(int number) {
        int setBits = 0;
        while (number > 0) {
            setBits += number & 1;
            number >>= 1;
        }
        return setBits;
    }
}
