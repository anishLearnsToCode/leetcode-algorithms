// https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter
// T: O(|word|)
// S: O(1)

public class MinimumTimeToTypeWordUsingSpecialTypewriter {
    public int minTimeToType(String word) {
        return movingTime(word) + word.length();
    }

    private int movingTime(String s) {
        int movingTime = 0, distance;
        for (int i = 1 ; i < s.length() ; i++) {
            distance = Math.abs(s.charAt(i) - s.charAt(i - 1));
            movingTime += Math.min(distance, 26 - distance);
        }
        distance = Math.abs(s.charAt(0) - 'a');
        return movingTime + Math.min(distance, 26 - distance);
    }
}
