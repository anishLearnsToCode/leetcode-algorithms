// https://leetcode.com/problems/maximum-odd-binary-number
// T: O(S)
// S: O(1)

public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        final int numberOfOnes = getNumberOfOnes(s);
        return "1".repeat(numberOfOnes - 1) + "0".repeat(s.length() - numberOfOnes) + "1";
    }

    private static int getNumberOfOnes(String s) {
        int count = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
