// Problem Number: 461
// Link: https://leetcode.com/problems/hamming-distance/

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int number = x ^ y, countOfSetBits = 0;

        while (number != 0) {
            countOfSetBits += number & 1;
            number = number >> 1;
        }

        return countOfSetBits;
    }
}
