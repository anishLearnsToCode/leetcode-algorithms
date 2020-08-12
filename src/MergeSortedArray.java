public class MergeSortedArray {
    public void merge(int[] array1, int n, int[] array2, int m) {
        int[] result = new int[m + n];
        for (int i = 0, j = 0, index = 0 ; i <= n && j <= m ; ) {
            if (i == n) {
                while (j < m) {
                    result[index++] = array2[j++];
                }
                break;
            }
            if (j == m) {
                while (i < n) {
                    result[index++] = array1[i++];
                }
                break;
            }

            if (array1[i] < array2[j]) {
                result[index++] = array1[i++];
            } else {
                result[index++] = array2[j++];
            }
        }

        copyContentInto(array1, result);
    }

    private static void copyContentInto(int[] array, int[] from) {
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = from[index];
        }
    }
}
