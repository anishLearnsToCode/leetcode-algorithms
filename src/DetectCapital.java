public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        return isAllCaps(word) || isAllLowerCase(word, 0) || firstCharIsCapital(word);
    }

    private boolean isAllCaps(String string) {
        for (int index = 0 ; index < string.length() ; index++) {
            if (Character.isLowerCase(string.charAt(index))) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllLowerCase(String string, int start) {
        for (int index = start ; index < string.length() ; index++) {
            if (Character.isUpperCase(string.charAt(index))) {
                return false;
            }
        }
        return true;
    }

    private boolean firstCharIsCapital(String string) {
        return Character.isUpperCase(string.charAt(0)) && isAllLowerCase(string, 1);
    }
}
