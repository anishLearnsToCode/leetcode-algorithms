// https://leetcode.com/problems/find-all-k-distant-indices-in-an-array
// T: O(N)
// S: O(N)

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {
    public List<Integer> findKDistantIndices(int[] array, int key, int k) {
        final List<Integer> result = new ArrayList<>();

        for (int index = 0 ; index < array.length ; index++) {
            if (array[index] == key) {
                int startIndex = Math.max(result.isEmpty() ? 0 : result.get(result.size() - 1) + 1, index - k);
                int endIndex = Math.min(index + k, array.length - 1);
                for (int i = startIndex ; i <= endIndex ; i++) {
                    result.add(i);
                }
            }
        }

        return result;
    }
}
