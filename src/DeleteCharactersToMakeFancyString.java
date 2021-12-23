// https://leetcode.com/problems/delete-characters-to-make-fancy-string
// T: O(|s|)
// S: O(|s|)

public class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        char current = s.charAt(0);
        final StringBuilder result = new StringBuilder().append(current);
        for (int i = 1, count = 1 ; i < s.length() ; i++) {
            if (s.charAt(i) == current) count++;
            else {
                count = 1;
                current = s.charAt(i);
            }
            if (count < 3) result.append(current);
        }
        return result.toString();
    }
}
