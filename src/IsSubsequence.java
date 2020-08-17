public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int index = 0 ;  index < t.length() && j < s.length() ; index++) {
            if (s.charAt(j) == t.charAt(index)) {
                j++;
            }
        }
        return j == s.length();
    }
}
