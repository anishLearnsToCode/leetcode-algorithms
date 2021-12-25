// https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum
// T: O(nloogn + klogk)
// S: o(n)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindSubsequenceOfLengthKWithTheLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        List<Number>numbers = toNumbersList(nums);
        numbers.sort(Comparator.comparingInt(a -> a.value));
        List<Number> topK = getLastK(numbers, k);
        topK.sort(Comparator.comparing(a -> a.index));
        return toArray(topK);
    }

    private List<Number> toNumbersList(int[] array) {
        final List<Number> numbers = new ArrayList<>(array.length);
        for (int index = 0 ; index < array.length ; index++) {
            numbers.add(new Number(array[index], index));
        }
        return numbers;
    }

    private List<Number> getLastK(List<Number> numbers, int k) {
        final List<Number> result = new ArrayList<>();
        for (int i = 0 ; i < k ; i++) {
            result.add(numbers.get(numbers.size() - 1 - i));
        }
        return result;
    }

    private int[] toArray(List<Number> numbers) {
        final int[] array = new int[numbers.size()];
        for (int i = 0 ; i < array.length ; i++) {
            array[i] = numbers.get(i).value;
        }
        return array;
    }

    private static final class Number {
        private final int value;
        private final int index;

        private Number(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
