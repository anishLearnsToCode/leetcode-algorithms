// https://leetcode.com/problems/valid-word-abbreviation
// T: O(|word|)
// S: O(1)

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(abbr.length() > word.length()) {
            return false;
        }

        int i = 0, j = 0;
        while(i < word.length() && j < abbr.length()) {
            final char wc = word.charAt(i), ac = abbr.charAt(j);
            // if both characters are different, return false
            if(Character.isLetter(ac) && wc != ac) return false;
            else{
                // encountering a digit
                if(Character.isDigit(ac)){
                    int a = ac - '0';
                    if(a == 0) return false;
                    // while we get digits, we create bigger number
                    while(j + 1 < abbr.length() && Character.isDigit(abbr.charAt(j + 1))){
                        a = a * 10 + abbr.charAt(j + 1) - '0';
                        j++;
                    }
                    // jump i end of digits position
                    i += a - 1;
                }
            }
            j++;
            i++;
        }
        return i == word.length() && j == abbr.length();
    }
}
