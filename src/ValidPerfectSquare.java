public class ValidPerfectSquare {
    public static boolean isPerfectSquare(long number) {
        long left = 0, right = number, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid == number) return true;
            else if (mid * mid < number) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
