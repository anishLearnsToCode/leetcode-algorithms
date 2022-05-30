// https://leetcode.com/problems/longest-consecutive-sequence
// T: O(n)
// S: O(n)

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        final Set<Integer> numbers = setFrom(nums);
        int maxLength = 0;

        for (int number : numbers) {
            if (!numbers.contains(number - 1)) {
                int length = 1;
                for (int i = number + 1 ; numbers.contains(i) ; i++) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    private Set<Integer> setFrom(int[] array) {
        final Set<Integer> set = new HashSet<>();
        for (int element : array) {
            set.add(element);
        }
        return set;
    }
}
