public class RangeSumQueryImmutable {
    private static class NumArray {
        private final int[] result;

        public NumArray(int[] array) {
            result = new int[array.length + 1];
            for (int index = 0 ; index < array.length ; index++) {
                result[index + 1] = result[index] + array[index];
            }
        }

        public int sumRange(int i, int j) {
            return result[j] - result[i];
        }
    }
}
