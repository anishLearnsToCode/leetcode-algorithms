// https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros
// T: O(N)
// S: O(1)

public class LongerContiguousSegmentOfOnesThanZeros {
    public boolean checkZeroOnes(String s) {
        return lengthContiguousSegment(s, '1') > lengthContiguousSegment(s, '0');
    }

    private int lengthContiguousSegment(String s, char c) {
        int maxLen = 0;
        for (int i = 0, current = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == c) current++;
            else current = 0;
            maxLen = Math.max(maxLen, current);
        }
        return maxLen;
    }
}
