public class HelloWorld {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        // skip all spaces at the end of the word
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        final int wordEndIndex = i;

        // arrive at the start of the word
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }

        return wordEndIndex - i;
    }
}
