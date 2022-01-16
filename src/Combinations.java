// https://leetcode.com/problems/combinations
// T: O(k * 2^n)
// S: O(k)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> result = new ArrayList<>();
        createCombinations(n, k, result);
        return result;
    }

    private void createCombinations(int n, int k, List<List<Integer>> result) {
        addCombinations(n, 1, k, result, new LinkedList<>());
    }

    private void addCombinations(int n, int current, int length, List<List<Integer>> result, LinkedList<Integer> combination) {
        if (combination.size() == length) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (current > n) return;
        combination.add(current);
        addCombinations(n, current + 1, length, result, combination);
        combination.removeLast();
        addCombinations(n, current + 1, length, result, combination);
    }
}
