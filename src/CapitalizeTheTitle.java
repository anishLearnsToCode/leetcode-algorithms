// https://leetcode.com/problems/capitalize-the-title
// T: O(|s|)
// S: O(|s|)

public class CapitalizeTheTitle {
    public String capitalizeTitle(String title) {
        final StringBuilder result = new StringBuilder();
        final String[] words = title.split(" ");
        for (String word : words) {
            if (word.length() <= 2) result.append(word.toLowerCase()).append(' ');
            else result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(' ');
        }
        return result.delete(result.length() - 1, result.length()).toString();
    }
}
