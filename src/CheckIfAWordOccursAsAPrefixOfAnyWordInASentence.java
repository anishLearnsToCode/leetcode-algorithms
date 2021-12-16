public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int matchIndex = -1;
        do {
            matchIndex = sentence.indexOf(searchWord, matchIndex + 1);
            if (matchIndex == -1) return -1;
            if (matchIndex == 0 || sentence.charAt(matchIndex - 1) == ' ') {
                return spacesUpto(sentence, matchIndex) + 1;
            }
        } while (matchIndex < sentence.length());
        return -1;
    }

    private static int spacesUpto(String string, int endIndex) {
        int spaces = 0;
        for (int index = 0 ; index < endIndex ; index++) {
            if (string.charAt(index) == ' ') spaces++;
        }
        return spaces;
    }
}
