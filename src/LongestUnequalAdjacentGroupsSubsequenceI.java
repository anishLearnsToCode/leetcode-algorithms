// https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i
// T: O(|groups|)
// S: O(1)

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        final List<String> result = new ArrayList<>();

        for (int i = 0, previous = -1 ; i < groups.length ; i++) {
            if (groups[i] != previous) {
                result.add(words[i]);
            }
            previous = groups[i];
        }

        return result;
    }
}
