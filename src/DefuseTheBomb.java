public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) return new int[code.length];
        final Code codeData = new Code(code);
        final int[] result = new int[code.length];
        if (k > 0) {
            for (int index = 0 ; index < result.length ; index++) {
                result[index] = codeData.getSlice(index + 1, index + k);
            }
        } else {
            for (int index = 0 ; index < result.length ; index++) {
                result[index] = codeData.getSlice(index + k, index - 1);
            }
        }
        return result;
    }

    private static final class Code {
        private final int[] sum;
        private final int codeSum;

        Code(int[] code) {
            this.sum = computeSum(code);
            this.codeSum = sum[sum.length - 1];
        }

        private int[] computeSum(int[] array) {
            final int[] sum = new int[array.length];
            sum[0] = array[0];
            for (int index = 1 ; index < array.length ; index++) {
                sum[index] = sum[index - 1] + array[index];
            }
            return sum;
        }

        private int getIndex(int index) {
            return (index + sum.length) % sum.length;
        }

        private int getSlice(int start, int end) {
            final int startIndex = getIndex(start), endIndex = getIndex(end);
            if (startIndex <= endIndex) {
                return sum[endIndex] - (startIndex == 0 ? 0: sum[startIndex - 1]);
            }
            return codeSum - sum[startIndex - 1] + sum[endIndex];
        }

        private int[] getFullSumArray(int length) {
            final int[] array = new int[length];
            for (int index = 0 ; index < length ; index++) {
                array[index] = codeSum;
            }
            return array;
        }
    }
}
