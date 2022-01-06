// https://leetcode.com/problems/permutations
// T: O(n * n!)
// S: O(n * n!)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations {
    private static final Map<Integer, List<List<Integer>>> PERMUTATION_MASKS = new HashMap<>();

    static {
        PERMUTATION_MASKS.put(1, List.of(List.of(0)));
        PERMUTATION_MASKS.put(2, List.of(
                List.of(0, 1),
                List.of(1, 0)
        ));
        PERMUTATION_MASKS.put(3, List.of(
                List.of(0, 1, 2),
                List.of(0, 2, 1),
                List.of(1, 0, 2),
                List.of(1, 2, 0),
                List.of(2, 0, 1),
                List.of(2, 1, 0)
        ));

        for (int i = 4 ; i <= 6 ; i++) {
            PERMUTATION_MASKS.put(i, getPermutationMask(i));
        }
    }

    private static List<List<Integer>> getPermutationMask(int size) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<List<Integer>> previousPermutations = PERMUTATION_MASKS.get(size - 1);
        for (List<Integer> mask : previousPermutations) {
            for (int insertionPosition = 0 ; insertionPosition < size ; insertionPosition++) {
                result.add(newPermutation(mask, insertionPosition));
            }
        }
        return result;
    }

    private static List<Integer> newPermutation(List<Integer> mask, int index) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < index ; i++) result.add(mask.get(i));
        result.add(mask.size());
        for (int i = index ; i < mask.size() ; i++) result.add(mask.get(i));
        return result;
    }

    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> results = new ArrayList<>();
        final List<List<Integer>> permutationMasks = PERMUTATION_MASKS.get(nums.length);
        for (List<Integer> mask : permutationMasks) {
            results.add(permute(nums, mask));
        }
        return results;
    }

    private List<Integer> permute(int[] array, List<Integer> mask) {
        final int[] result = new int[array.length];
        for (int i = 0 ; i < array.length ; i++) {
            result[mask.get(i)] = array[i];
        }
        return toList(result);
    }

    private List<Integer> toList(int[] array) {
        final List<Integer> result = new ArrayList<>(array.length);
        for (int element : array) {
            result.add(element);
        }
        return result;
    }
}
