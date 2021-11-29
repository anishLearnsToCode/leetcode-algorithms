public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        boolean isIncreasing = true;
        for (int index = 1 ; index < arr.length ; index++) {
            if (arr[index] == arr[index - 1]) return false;
            if (arr[index] < arr[index - 1] && isIncreasing) {
                if (index == 1) return false;
                isIncreasing = false;
            } else if (arr[index] > arr[index - 1] && !isIncreasing) {
                return false;
            }
        }
        return !isIncreasing;
    }
}
