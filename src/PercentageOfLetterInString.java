// https://leetcode.com/problems/percentage-of-letter-in-string
// T: O(|s|)
// S: O(1)

public class PercentageOfLetterInString {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int index = 0 ; index < s.length() ; index++) {
            if (letter == s.charAt(index)) {
                count++;
            }
        }
        return (int) (((double) count / s.length()) * 100);
    }
}
