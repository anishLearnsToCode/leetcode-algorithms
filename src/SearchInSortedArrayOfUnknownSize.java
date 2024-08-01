// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size
// T: O(logN)
// S: O(1)

public class SearchInSortedArrayOfUnknownSize {
    public interface ArrayReader {
        int get(int index);
    }

    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1, middle;

        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }

        while (left <= right) {
            middle = left + (right - left) / 2;
            if (reader.get(middle) == target) return middle;
            else if (reader.get(middle) < target) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }
}
