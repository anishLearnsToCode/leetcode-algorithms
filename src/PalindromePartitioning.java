// https://leetcode.com/problems/palindrome-partitioning
// T: O(n * 2^n)
// S: O(n) for recursion call stack

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        final int length = s.length();
        final boolean[][] dp = new boolean[length][length];
        final List<List<String>> result = new ArrayList<>();
        addValidPartitions(s, 0, dp, result, new LinkedList<>());
        return result;
    }

    private void addValidPartitions(String s, int start, boolean[][] dp, List<List<String>> result, LinkedList<String> current) {
        if (start == s.length()) result.add(new ArrayList<>(current));

        for (int end = start ; end < s.length() ; end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                current.addLast(s.substring(start, end + 1));
                addValidPartitions(s, end + 1, dp, result, current);
                current.pollLast();
            }
        }
    }
}
