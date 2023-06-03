// https://leetcode.com/problems/categorize-box-according-to-criteria
// T: O(1)
// S: O(1)

public class CategorizeBoxAccordingToCriteria {
    public String categorizeBox(int length, int width, int height, int mass) {
        final boolean isBulky = isBulky(length, width, height, mass);
        final boolean isHeavy = mass >= 100;

        if (isBulky && isHeavy) return "Both";
        if (!isBulky && !isHeavy) return "Neither";
        if (isBulky) return "Bulky";
        return "Heavy";
    }

    private boolean isBulky(long length, long width, long height, long mass) {
        long volume = length * width * height;
        return length >= 10_000 || width >= 10_000 || height >= 10_000 || mass >= 10_000 || volume >= 1_000_000_000;
    }
}
