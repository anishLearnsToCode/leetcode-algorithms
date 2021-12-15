public class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        final int ones = getFrequency(s, '1');
        int score = 0;
        for (int index = 0, left = 0, right = ones ; index < s.length() - 1 ; index++) {
            left += s.charAt(index) == '0' ? 1 : 0;
            right -= s.charAt(index) == '0' ? 0 : 1;
            score = Math.max(score, left + right);
        }
        return score;
    }

    private int getFrequency(String s, char character) {
        int frequency = 0;
        for (int index = 0 ; index < s.length() ; index++) {
            if (s.charAt(index) == character) frequency++;
        }
        return frequency;
    }
}
