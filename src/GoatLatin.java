import java.util.Set;

public class GoatLatin {
    private static final Set<Character> VOWELS  = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder(), word = new StringBuilder();
         char firstLetter = ' ';
        int wordCount = 1;
        boolean vowelWord = false, newWord = true;
        for (int index = 0 ; index < sentence.length() ; index++) {
            if (newWord) {
                if (index == sentence.length() - 1) {
                    result.append(toGoatLatin(wordCount, new StringBuilder(),
                            false, sentence.charAt(index)));
                    break;
                }
                if (isVowel(sentence.charAt(index))) {
                    vowelWord = true;
                    word.append(sentence.charAt(index));
                } else {
                    vowelWord = false;
                    firstLetter = sentence.charAt(index);
                }

                newWord = false;
            } else if (sentence.charAt(index) == ' ' || index == sentence.length() - 1) {
                newWord = true;
                if (index == sentence.length() - 1) word.append(sentence.charAt(index));
                result.append(toGoatLatin(wordCount, word, vowelWord, firstLetter));
                word = new StringBuilder();
                wordCount++;
            } else {
                word.append(sentence.charAt(index));
            }
        }
        return result.toString();
    }

    private StringBuilder toGoatLatin(int wordCount, StringBuilder word, boolean vowelWord, char firstLetter) {
        return new StringBuilder()
                .append(wordCount == 1 ? "" : ' ')
                .append(word)
                .append(vowelWord ? "" : firstLetter)
                .append("ma")
                .append("a".repeat(wordCount));
    }

    private boolean isVowel(char character) {
        return VOWELS.contains(character);
    }
}
