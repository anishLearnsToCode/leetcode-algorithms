// https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room
// T: O(N)
// S: O(1)

public class MinimumNumberOfChairsInAWaitingRoom {
    public int minimumChairs(String s) {
        int minChairs = 0;
        for (int i = 0, sum = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == 'E') {
                sum++;
            } else {
                sum--;
            }
            minChairs = Math.max(minChairs, sum);
        }
        return minChairs;
    }
}
