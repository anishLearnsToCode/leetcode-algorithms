// https://leetcode.com/problems/find-maximum-number-of-string-pairs
// T: O(N * |s|)
// S: O(N * |s|)

import java.util.HashSet;
import java.util.Set;

public class FindMaximumNumberOfStringPairs {
    public int maximumNumberOfStringPairs(String[] words) {
        final Set<String> strings = new HashSet<>();
        int pairs = 0;
        for (String word : words) {
            final String reversed = new StringBuilder(word).reverse().toString();
            if (strings.contains(reversed)) {
                pairs++;
                strings.remove(reversed);
            } else {
                strings.add(word);
            }
        }
        return pairs;
    }
}
