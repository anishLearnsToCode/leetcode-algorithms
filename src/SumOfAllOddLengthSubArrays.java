public class SumOfAllOddLengthSubArrays {
    public int sumOddLengthSubarrays(int[] array) {
        int sum = 0;
        for (int index = 0 ; index < array.length ; index++) {
            sum += (((array.length - index) * (index + 1) + 1) / 2) * array[index];
        }
        return sum;
    }
}
