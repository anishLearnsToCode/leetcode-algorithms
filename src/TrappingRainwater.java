// T: O(n)
// S: O(1)

public class TrappingRainwater {
    public static int trap(int[] height) {
        int result = 0;
        for (int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0 ; left < right ; ) {
            if (height[left] < height[right]) {
                if (leftMax < height[left]) leftMax = height[left];
                else result += leftMax - height[left];
                left++;
            } else {
                if (rightMax < height[right]) rightMax = height[right];
                else result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}
