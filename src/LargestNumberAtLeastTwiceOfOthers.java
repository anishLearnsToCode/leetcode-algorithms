public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int largestIndex = largestIndex(nums), largest = nums[largestIndex];
        for (int number : nums) {
            if (number != largest && 2 * number > largest) {
                return -1;
            }
        }
        return largestIndex;
    }

    private int largestIndex(int[] array) {
        int largest = Integer.MIN_VALUE, largestIndex = -1;
        for (int index = 0 ; index < array.length ; index++) {
            if (array[index] > largest) {
                largest = array[index];
                largestIndex = index;
            }
        }
        return largestIndex;
    }
}
