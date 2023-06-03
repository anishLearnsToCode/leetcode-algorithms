// https://leetcode.com/problems/circular-sentence
// T: O(N)
// S: O(1)

public class CircularSentence {
    public boolean isCircularSentence(String sentence) {
        for (int index = 0 ; index < sentence.length() ; index++) {
            char letter = sentence.charAt(index);
            if (letter == ' ' && sentence.charAt(index - 1) != sentence.charAt(index + 1)) {
                return false;
            }
        }
        return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
    }
}
