// https://leetcode.com/problems/container-with-most-water
// T: O(n)
// S: O(1)

public class ContainerWitMostWater {
    public static int maxArea(int[] height) {
        int water = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            water = Math.max(water, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) j--;
            else i++;
        }
        return water;
    }
}
