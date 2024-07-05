// https://leetcode.com/problems/find-the-k-or-of-an-array
// T: O(N)
// S: O(1)

public class FindTheKOrOfAnArray {
    public int findKOr(int[] array, int k) {
        int mask = 0;

        for (int i = 0 ; i < 32 ; i++) {
            int count = 0;
            for (int element : array) {
                if ((element & (1 << i)) > 0) {
                    count++;
                }
                if (count == k) {
                    break;
                }
            }

            if(count == k) {
                mask |= (1 << i);
            }
        }

        return mask;
    }
}
