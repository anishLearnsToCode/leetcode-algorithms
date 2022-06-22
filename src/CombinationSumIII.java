// https://leetcode.com/problems/combination-sum-iii
// T: O(9^k)
// S: O(k)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    private final List<List<Integer>> result = new ArrayList<>();
    private int sum;

    public List<List<Integer>> combinationSum3(int k, int n) {
        sum = n;
        combinationSum(1, Math.min(sum / 2, 9), 0, k - 1, new LinkedList<>());
        return result;
    }

    private void combinationSum(int start, int end, int currentSum, int k, LinkedList<Integer> current) {
        if (k == 0) {
            if (currentSum < sum && sum - currentSum >= start && sum - currentSum <= 9) {
                current.add(sum - currentSum);
                result.add(new ArrayList<>(current));
                current.pollLast();
            }
            return;
        }

        for (int i = start ; i <= end ; i++) {
            current.add(i);
            currentSum += i;
            combinationSum(i + 1, Math.min((sum - currentSum) / 2, 9), currentSum, k - 1, current);
            currentSum -= i;
            current.pollLast();
        }
    }
}
