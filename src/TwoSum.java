// https://leetcode.com/problems/two-sum/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        int target = scanner.nextInt();
        System.out.println(Arrays.toString(twoSum(array, target)));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    public static int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> indices = getIndices(array);
        for (int index = 0 ; index < array.length ; index++) {
            int number = array[index];
            if (indices.containsKey(target - number) && indices.get(target - number) != index) {
                return new int[] {index, indices.get(target - number)};
            }
        }
        return new int[0];
    }

    private static Map<Integer, Integer> getIndices(int[] array) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int index = 0 ; index < array.length ; index++) {
            indices.put(array[index], index);
        }
        return indices;
    }
}
