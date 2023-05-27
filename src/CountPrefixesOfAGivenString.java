// https://leetcode.com/problems/count-prefixes-of-a-given-string
// T: O(|words| * |s|)
// S: O(1)

public class CountPrefixesOfAGivenString {
    public int countPrefixes(String[] words, String s) {
        int result = 0;
        for (String word : words) {
            if (s.startsWith(word)) result++;
        }
        return result;
    }
}
