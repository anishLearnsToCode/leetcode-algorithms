// https://leetcode.com/problems/combination-sum
// T: O(|candidates| ^ target)
// S: O(target + candidate ^ 2) // not sure tho --> if anyone has any idea please feel free to contact me

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private final List<List<Integer>> result = new ArrayList<>();
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        combinationSum(new ArrayList<>(), 0, 0);
        return result;
    }

    public void combinationSum(List<Integer> current, int sum, int index) {
        if (sum == target) {
            result.add(current);
            return;
        } else if (sum > target) return;
        for (int i = index ; i < candidates.length ; i++) {
            List<Integer> newCandidate = new ArrayList<>(current);
            newCandidate.add(candidates[i]);
            combinationSum(newCandidate, sum + candidates[i], i);
        }
    }
}
