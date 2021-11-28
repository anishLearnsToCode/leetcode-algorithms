public class SortArrayByParityII {
    public static int[] sortArrayByParityII(int[] array) {
        for (int i = 0, j = 1; i < array.length ; i += 2) {
            if ((array[i] & 1) == 1) {
                while (j < array.length && ((array[j] & 1) == 1)) j += 2;
                swap(array, i, j);
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
