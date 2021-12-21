public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public boolean checkOnesSegment(String s) {
        int segments = 0;
        boolean isInSegment = false;
        for (int index = 0 ; index < s.length() ; index++) {
            if (!isInSegment && s.charAt(index) == '1') {
                isInSegment = true;
                segments++;
            } else if (isInSegment && s.charAt(index) == '0') {
                isInSegment = false;
            }
        }
        return segments <= 1;
    }
}
