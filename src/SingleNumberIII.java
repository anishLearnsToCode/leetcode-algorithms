// https://leetcode.com/problems/single-number-iii
// T: O(N)
// S: O(1)

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        // get xor of 2 unique numbers a ^ b
        int diff = getXor(nums);

        diff = getLastSetBit(diff);

        final int[] result = {0, 0};
        for (int element : nums) {
            // different set bit
            if ((element & diff) == 0) {
                result[0] ^= element;
            } else result[1] ^= element;
        }

        return result;
    }

    private int getXor(int[] array) {
        int diff = 0;
        for (int element : array) {
            diff ^= element;
        }
        return diff;
    }

    private int getLastSetBit(int x) {
        return x & -x;
    }
}
