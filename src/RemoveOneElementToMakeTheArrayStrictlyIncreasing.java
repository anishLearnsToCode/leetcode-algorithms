public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {
    public boolean canBeIncreasing(int[] array) {
        if (array[0] >= array[1]) {
            if (array.length == 2) return true;
            return array[2] > array[1] && isStrictlyIncreasing(array, 3);
        }
        boolean firstAnomaly = true;
        for (int index = 2 ; index < array.length ; index++) {
            if (array[index] <= array[index - 1]) {
                if (!firstAnomaly) return false;
                firstAnomaly = false;
                if (index == array.length - 1) return true;
                if (array[index + 1] > array[index - 1]) continue;
                if (array[index + 1] > array[index] && array[index] > array[index - 2]) continue;
                return false;
            }
        }
        return true;
    }

    private boolean isStrictlyIncreasing(int[] array, int start) {
        for (int i = start ; i < array.length ; i++) {
            if (array[i] <= array[i - 1]) return false;
        }
        return true;
    }
}
