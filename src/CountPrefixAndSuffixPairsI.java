// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i
// T: O(|words|^2 * |words[i].length|)
// S: O(1)

public class CountPrefixAndSuffixPairsI {
    public int countPrefixSuffixPairs(String[] words) {
        int pairs = 0;
        for (int i = 0 ; i < words.length ; i++) {
            for (int j = i + 1 ; j < words.length ; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    private static boolean isPrefixAndSuffix(String a, String b) {
        if (a.length() > b.length()) {
            return false;
        }

        // prefix
        for (int i = 0 ; i < a.length() ; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        //suffix
        for (int i = 0; i < a.length() ; i++) {
            if (a.charAt(i) != b.charAt(b.length() - a.length() + i)) {
                return false;
            }
        }

        return true;
    }
}
