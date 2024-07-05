// https://leetcode.com/problems/last-visited-integers
// T: O(N)
// S: O(N)

import java.util.ArrayList;
import java.util.List;

public class LastVisitedIntegers {
    public List<Integer> lastVisitedIntegers(int[] array) {
        final List<Integer> seen = new ArrayList<>();
        final List<Integer> ans = new ArrayList<>();

        int k = 0;

        for (int element : array) {
            if (element == -1) {
                k++;
                if (k > seen.size()) {
                    ans.add(-1);
                } else {
                    ans.add(seen.get(seen.size() - k));
                }
            } else {
                k = 0;
                seen.add(element);
            }
        }

        return ans;
    }
}
