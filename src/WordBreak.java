// https://leetcode.com/problems/word-break
// T: O(s^3 + w)
// S: O(s + w)

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        final Set<String> words = new HashSet<>(wordDict);
        final boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1 ; i <= s.length() ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }
}
