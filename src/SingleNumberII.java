// https://leetcode.com/problems/single-number-ii
// T: O(n)
// S: O(1)

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int x1 = 0, x2 = 0, mask = 0;
        for (int element : nums) {
            x2 ^= (x1 & element);
            x1 ^= element;
            mask = ~(x1 & x2);
            x1 &= mask;
            x2 &= mask;
        }
        return x1;
    }
}
