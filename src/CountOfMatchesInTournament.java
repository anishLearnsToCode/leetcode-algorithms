// https://leetcode.com/problems/count-of-matches-in-tournament
// T: O(log N)
// S: O(log N)

public class CountOfMatchesInTournament {
    public int numberOfMatches(int n) {
        if (n == 1) return 0;
        return n / 2 + numberOfMatches(n - n / 2);
    }
}
