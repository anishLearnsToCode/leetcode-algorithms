// https://leetcode.com/problems/jump-game-ii
// T: O(n)
// S: O(1)

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int jumps = 0;
        for (int current = 0 ; current < nums.length ; jumps++) {
            int maxJumpIndex = current, maxJump = nums[current];
            for (int i = current ; i < current + nums[current] + 1 && i < nums.length ; i++) {
                if (i == nums.length - 1) return jumps + 1;
                int potential = i - current + nums[i];
                if (potential > maxJump) {
                    maxJump = potential;
                    maxJumpIndex = i;
                } else if (potential == maxJump) maxJumpIndex = i;
            }
            current = maxJumpIndex;
        }
        return jumps;
    }
}
