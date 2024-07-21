// https://leetcode.com/problems/find-the-encrypted-string
// T: O(|s|)
// S: O(|s|)

public class FindTheEncryptedString {
    public String getEncryptedString(String s, int k) {
        final int rotations = k % s.length();
        if (rotations == 0) {
            return s;
        }
        return rotateString(s, rotations);
    }

    private static String rotateString(String s, int rotations) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++) {
            builder.append(s.charAt((i + rotations) % s.length()));
        }
        return builder.toString();
    }
}
