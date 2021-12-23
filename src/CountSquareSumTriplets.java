// https://leetcode.com/problems/count-square-sum-triples
// T: O(n ^ 2)
// S: O(1)

public class CountSquareSumTriplets {
    public int countTriples(int n) {
        int triplets = 0;
        for (int i = 1 ; i <= n - 2 ; i++) {
            for (int j = i + 1 ; j <= n - 1 ; j++) {
                int sqrt = (int) Math.sqrt(i * i + j * j);
                if (sqrt <= n && sqrt * sqrt == i * i + j * j) triplets++;
            }
        }
        return 2 * triplets;
    }
}
