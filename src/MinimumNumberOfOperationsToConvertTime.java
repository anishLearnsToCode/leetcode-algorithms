// https://leetcode.com/problems/minimum-number-of-operations-to-convert-time
// T: O(1)
// S: O(1)

public class MinimumNumberOfOperationsToConvertTime {
    private final static int[] MINUTE_INCREMENTS = {60, 15, 5, 1};

    public int convertTime(String current, String correct) {
        final int hour1 = Integer.parseInt(current.substring(0, 2)), hour2 = Integer.parseInt(correct.substring(0, 2));
        final int minutes1 = Integer.parseInt(current.substring(3)), minutes2 = Integer.parseInt(correct.substring(3));
        final int totalMinutes1 = hour1 * 60 + minutes1, totalMinutes2 = hour2 * 60 + minutes2;

        int operations = 0;
        int difference = totalMinutes2 - totalMinutes1;

        for (int i = 0 ; i < MINUTE_INCREMENTS.length && difference > 0; i++) {
            operations += difference / MINUTE_INCREMENTS[i];
            difference -= (difference / MINUTE_INCREMENTS[i]) * MINUTE_INCREMENTS[i];
        }

        return operations;
    }
}
