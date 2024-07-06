// https://leetcode.com/problems/distribute-candies-among-children-i
// n = number of slots, c = candies
// T: O(n ^ c)
// S: O(c)

public class DistributeCandiesAmongChildrenI {
    public int distributeCandies(int n, int limit) {
        // Check if n is greater than 3 times limit
        if (n > 3 * limit) {
            return 0;
        }

        int ans = nC2(n + 2);

        if (n > limit) {
            ans -= 3 * nC2(n - limit + 1);
        }

        if (n - 2 >= 2 * limit) {
            ans += 3 * nC2(n - 2 * limit);
        }

        // Return the final result
        return ans;
    }

    private static int nC2(int n) {
        return (n * (n - 1)) / 2;
    }
}
