public class LengthOfLastWord {
    public int lengthOfLastWord(String sentence) {
        String[] words = sentence.split(" ");
        if (words.length == 0) {
            return 0;
        }

        return words[words.length - 1].length();
    }
}
