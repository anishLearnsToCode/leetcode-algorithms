public class DuplicateZeros {
    public void duplicateZeros(int[] array) {
        int removals = 0, k = array.length - 1;
        for (int i = 0 ; i < array.length - removals ; i++) {
            if (array[i] == 0) {
                if (i == array.length - 1 - removals) {
                    array[k--] = 0;
                }
                removals++;
            }
        }
        for (int i = array.length - 1 - removals ; i >= 0 ; i--, k--) {
            if (array[i] == 0) {
                array[k] = array[k - 1] = 0;
                k--;
            } else {
                array[k] = array[i];
            }
        }
    }
}
