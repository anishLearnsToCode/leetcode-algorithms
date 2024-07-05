// https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i
// T: O(N^2)
// S: O(N)

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubarraysDistinctElementSumOfSquaresI {
    public int sumCounts(List<Integer> array) {
        int sum = 0;

        for (int i = 0 ; i < array.size() ; i++) {
            final Set<Integer> subArray = new HashSet<>();
            for (int j = i ; j < array.size() ; j++) {
                subArray.add(array.get(j));
                sum += subArray.size() * subArray.size();
            }
        }

        return sum;
    }
}
