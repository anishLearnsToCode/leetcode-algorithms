// https://leetcode.com/problems/maximum-product-difference-between-two-pairs
// T: O(N)
// S: O(1)

public class MaximumProductDifferenceBetweenTwoPairs {
    public int maxProductDifference(int[] nums) {
        Pair largest = getLargestAndSecondLargest(nums);
        Pair smallest = getSmallestAndSecondSmallest(nums);
        return largest.a * largest.b - smallest.a * smallest.b;
    }

    private Pair getLargestAndSecondLargest(int[] array) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int element : array) {
            if (element > largest) {
                int temp = largest;
                largest = element;
                secondLargest = temp;
            } else if (element > secondLargest) {
                secondLargest= element;
            }
        }
        return new Pair(largest, secondLargest);
    }

    private Pair getSmallestAndSecondSmallest(int[] array) {
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int element : array) {
            if (element < smallest) {
                int temp = smallest;
                smallest = element;
                secondSmallest = temp;
            } else if (element < secondSmallest) {
                secondSmallest = element;
            }
        }
        return new Pair(smallest, secondSmallest);
    }

    private static final class Pair {
        private final int a;
        private final int b;

        private Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
