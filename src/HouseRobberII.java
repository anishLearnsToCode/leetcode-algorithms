// https://leetcode.com/problems/house-robber-ii
// T: O(N)
// S: O(1)

public class HouseRobberII {
    public int rob(int[] array) {
        if (array.length == 1) return array[0];
        if (array.length == 2) return Math.max(array[0], array[1]);

        return Math.max(
                rob(array, 0, array.length - 2),
                rob(array, 1, array.length - 1)
        );
    }

    public int rob(int[] array, int start, int end) {
        int a = array[start], b = Math.max(array[start], array[start + 1]), c = Math.max(a, b);
        for (int i = start + 2 ; i <= end ; i++) {
            c = Math.max(array[i] + a, b);
            a = b;
            b = c;
        }
        return c;
    }
}
