// https://leetcode.com/problems/latest-time-you-can-obtain-after-replacing-characters
// T: O(1)
// S: O(1)

public class LatestTimeYouCanObtainAfterReplacingCharacters {
    public String findLatestTime(String s) {
        return maxHour(s.substring(0, 2)) + ":" + maxMinutes(s.substring(3));
    }

    private static String maxHour(String s) {
        if (s.charAt(0) == '?' && s.charAt(1) == '?') {
            return "11";
        }
        if (s.charAt(0) == '?') {
            return (s.charAt(1) <= '1' ? "1" : "0") + s.charAt(1);
        }
        if (s.charAt(1) == '?') {
            return s.charAt(0) + (s.charAt(0) == '0' ? "9" : "1");
        }
        return s;
    }

    private static String maxMinutes(String s) {
        if (s.charAt(0) == '?' && s.charAt(1) == '?') {
            return "59";
        }
        if (s.charAt(0) == '?') {
            return "5" + s.charAt(1);
        }
        if (s.charAt(1) == '?') {
            return s.charAt(0) + "9";
        }
        return s;
    }
}
