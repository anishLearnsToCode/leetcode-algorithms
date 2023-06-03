// https://leetcode.com/problems/maximum-value-of-a-string-in-an-array
// T: O(|strings| * |strings[i]|)
// S: O(1)

public class MaximumValueOfAStringInAnArray {
    public int maximumValue(String[] strings) {
        int max = -1;
        for (String string : strings) {
            max = Math.max(max, value(string));
        }
        return max;
    }

    private int value(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            return string.length();
        }
    }
}
