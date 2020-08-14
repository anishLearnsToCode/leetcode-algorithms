public class ValidPalindrome {
    public boolean isPalindrome(String string) {
        final StringBuilder alphanumeric = toAlphaNumeric(string);
        for (int index = 0 ; index < alphanumeric.length() / 2 ; index++) {
            if (alphanumeric.charAt(index) != alphanumeric.charAt(alphanumeric.length() - index - 1)) {
                return false;
            }
        }
        return true;
    }

    private static StringBuilder toAlphaNumeric(String string) {
        StringBuilder result = new StringBuilder();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            if (Character.isAlphabetic(character) || Character.isDigit(character)) {
               result.append(Character.toLowerCase(character));
            }
        }
        return result;
    }
}
