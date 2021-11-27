public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        for (int index = 1 ; index < arr.length ; index++) {
            if (arr[index] < arr[index - 1]) return index - 1;
        }
        return -1;
    }
}
