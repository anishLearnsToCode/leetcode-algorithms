// https://leetcode.com/problems/longest-common-prefix/

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] array) {
        if (array.length == 0) {
            return "";
        }

        String result = array[0];
        for (int index = 1 ; index < array.length ; index++) {
            result = longestCommonPrefix(result, array[index]);
        }
        return result;
    }

    private String longestCommonPrefix(String first, String second) {
        for (int index = 0 ; index < first.length() && index < second.length() ; index++) {
            if (first.charAt(index) != second.charAt(index)) {
                return first.substring(0, index);
            }
        }
        return first.length() < second.length() ? first : second;
    }
}
