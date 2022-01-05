// https://leetcode.com/problems/search-in-rotated-sorted-array
// T: O(logN)
// SL O(1)

public class SearchInRotatedSortedArray {
    int search(int[] array, int target) {
        final int shift = minElementIndex(array);
        int left = 0, right = array.length - 1, middle, realMiddle;
        while (left <= right) {
            middle = (left + right) / 2;
            realMiddle = (middle + shift) % array.length;
            if(array[realMiddle] == target) return realMiddle;
            if(array[realMiddle] < target) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }

    private int minElementIndex(int[] array) {
        int left = 0, right = array.length - 1, middle;
        while(left < right){
            middle = (left + right) / 2;
            if(array[middle] > array[right]) left = middle + 1;
            else right = middle;
        }
        return left;
    }
}
