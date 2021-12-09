public class DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        final int totalElements = sumOfFrequency(nums);
        final int[] result = new int[totalElements];
        for (int i = 1, k = 0; i < nums.length ; i += 2) {
            for (int j = 0 ; j < nums[i - 1] ; j++) {
                result[k++] = nums[i];
            }
        }
        return result;
    }

    private int sumOfFrequency(int[] array) {
        int sum = 0;
        for (int i = 0 ; i < array.length ; i += 2) {
            sum += array[i];
        }
        return sum;
    }
}
