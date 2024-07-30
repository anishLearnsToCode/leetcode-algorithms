import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class HelloWorld {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final Set<List<Integer>> result = new HashSet<>();
        computeSums(candidates, target, result, 0, new ArrayList<>(), 0);
        return new ArrayList<>(result);
    }

    private static void computeSums(int[] candidates, int target, Set<List<Integer>> result, int currentSum, List<Integer> current, int i) {
        if (currentSum > target || i >= candidates.length) {
            return;
        }
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        computeSums(candidates, target, result, currentSum, current, i + 1);
        current.add(candidates[i]);
        computeSums(candidates, target, result, currentSum + candidates[i], current, i);
        computeSums(candidates, target, result, currentSum + candidates[i], current, i + 1);
        current.removeLast();
    }
}