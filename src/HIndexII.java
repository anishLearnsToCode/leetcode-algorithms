// https://leetcode.com/problems/h-index-ii
// T: O(log(N))
// S: O(1)

public class HIndexII {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[] {0, 5, 5, 5, 5}));
    }

    public static int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (citations[middle] == citations.length - middle) return citations[middle];
            else if (citations[middle] > citations.length - middle) right = middle - 1;
            else left = middle + 1;
        }
        return citations.length - left;
    }
}
