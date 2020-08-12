public class Sqrtx {
    public static int mySqrt(int number) {
        if (number <= 1) {
            return number;
        }

        int left = 0, right = number / 2;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left + 1) / 2;
            int sqrt = number / mid;
            if (mid == sqrt) return mid;
            else if (mid > sqrt) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}
