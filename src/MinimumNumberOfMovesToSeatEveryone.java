// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone
// T: O(n log(n))
// S: O(1)

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int minMoves = 0;
        for (int i = 0 ; i < students.length ; i++) {
            minMoves += Math.abs(seats[i] - students[i]);
        }
        return minMoves;
    }
}
