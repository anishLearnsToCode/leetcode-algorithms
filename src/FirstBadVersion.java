public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1, right = n, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid) && !isBadVersion(mid - 1)) return mid;
            else if (!isBadVersion(mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    // implemented by leetcode (just reference here)
    private static boolean isBadVersion(int version) {
        return false;
    }
}
