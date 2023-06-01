// https://leetcode.com/problems/number-of-valid-clock-times
// T: O(1)
// S: O(1)

public class NumberOfValidClockTimes {
    private static final char QUESTION = '?';

    public int countTime(String time) {
        return numberOfValidHourStrings(time.substring(0, 2)) * numberOfValidMinuteStrings(time.substring(3));
    }

    private int numberOfValidMinuteStrings(String mm) {
        final char first = mm.charAt(0), second = mm.charAt(1);

        if (first == QUESTION && second == QUESTION) return 60;
        if (first != QUESTION && second != QUESTION) return 1;
        if (first != QUESTION) return 10;
        return 6;
    }

    private int numberOfValidHourStrings(String hh) {
        final char first = hh.charAt(0), second = hh.charAt(1);

        if (first == QUESTION && second == QUESTION) return 24;
        if (first != QUESTION && second != QUESTION) return 1;

        if (first != QUESTION) {
            if (first == '2') return 4;
            return 10;
        }

        if (second > '3') return 2;
        return 3;
    }
}
