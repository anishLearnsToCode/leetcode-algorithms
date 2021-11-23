public class BinarySearch {
    public int search(int[] array, int val) {
        int left = 0, right = array.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle] == val) return middle;
            else if (array[middle] > val) right = middle - 1;
            else left = middle + 1;
        }

        return -1;
    }
}
