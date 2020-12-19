import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreatestElement = getNextGreaterElementsFor(nums2);
        int[] result = new int[nums1.length];
        for (int index = 0 ; index < nums1.length ; index++) {
            result[index] = nextGreatestElement.get(nums1[index]);
        }
        return result;
    }

    private static Map<Integer, Integer> getNextGreaterElementsFor(int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int element : array) {
            while (!stack.isEmpty() && element > stack.peek()) {
                result.put(stack.peek(), element);
                stack.pop();
            }
            stack.push(element);
        }

        while (!stack.isEmpty()) {
            result.put(stack.pop(), -1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2});
        System.out.println(Arrays.toString(result));
    }
}
