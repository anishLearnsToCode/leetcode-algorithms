public class ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();
        for (int index = 0 ; index < s.length() ; index++) {
            result.append(toLowerCase(s.charAt(index)));
        }
        return result.toString();
    }

    private char toLowerCase(char character) {
        return isUpperCase(character) && isAlphabet(character) ? (char) (character + 32) : character;
    }

    private boolean isAlphabet(char character) {
        return isUpperCase(character) || isLowerCase(character);
    }

    private boolean isLowerCase(char character) {
        return 97 <= character && character <= 122;
    }

    private boolean isUpperCase(char character) {
        return 65 <= character && character <= 90;
    }
}
