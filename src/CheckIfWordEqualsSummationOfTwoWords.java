// https://leetcode.com/problems/check-if-word-equals-summation-of-two-words
// T: O(|f1| + |f2| + |f3|)
// S: O(1)

public class CheckIfWordEqualsSummationOfTwoWords {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return toNumber(firstWord) + toNumber(secondWord) == toNumber(targetWord);
    }

    private int toNumber(String s) {
        int sum = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            sum *= 10;
            sum += s.charAt(i) - 'a';
        }
        return sum;
    }
}
