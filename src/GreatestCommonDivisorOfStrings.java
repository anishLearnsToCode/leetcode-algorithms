public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (!patternExist(str1, str2)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private boolean patternExist(String str1, String str2) {
        for (int i = 0, j = 0 ; i < str1.length() ; i++, j = (j + 1) % str2.length()) {
            if (str1.charAt(i) != str2.charAt(j)) return false;
        }
        return true;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
