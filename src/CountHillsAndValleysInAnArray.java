// https://leetcode.com/problems/count-hills-and-valleys-in-an-array

public class CountHillsAndValleysInAnArray {
    public int countHillValley(int[] array) {
        int result = 0, left = array[0];
        for (int index = 1 ; index < array.length - 1; index++) {
            if ((left < array[index] && array[index] > array[index + 1]) || (left > array[index] && array[index] < array[index + 1])) {
                result++;
                left = array[index];
            }
        }
        return result;
    }
}
