public class InterleavingString {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        for (int i = 0, j = 0, t = 0 ; i <= s1.length() && j <= s2.length() && t < s3.length() ; t++) {
            if (i < s1.length() && s3.charAt(t) == s1.charAt(i)) i++;
            else if (j < s2.length() && s3.charAt(t) == s2.charAt(j)) j++;
            else return false;
        }
        return true;
    }
}
