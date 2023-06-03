// https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three
// T: O(N)
// S: O(1)

public class AverageValueOfEvenNumbersThatAreDivisibleByThree {
    public int averageValue(int[] array) {
        int sum = 0, count = 0;
        for (int element : array) {
            if (element % 6 == 0) {
                sum  += element;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }
}
