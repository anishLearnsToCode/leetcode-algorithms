public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int left = 1, right = n, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int guess = guess(mid);
            if (guess == 0) return mid;
            else if (guess == -1) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    // dummy function - has been defined by Leetcode
    public int guess(int num) {
        return 0;
    }
}
