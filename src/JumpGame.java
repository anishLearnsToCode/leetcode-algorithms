// https://leetcode.com/problems/jump-game
// T: O(N)
// S: O(1)

public class JumpGame {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 2 ; i >= 0 ; i--) {
            if (i + nums[i] >= last) last = i;
        }
        return last == 0;
    }
}
