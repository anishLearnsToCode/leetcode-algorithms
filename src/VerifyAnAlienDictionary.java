import java.util.Comparator;

public class VerifyAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        AlienLanguageComparator alienLanguageComparator = new AlienLanguageComparator(order);
        for (int i = 1 ; i < words.length ; i++) {
            if (alienLanguageComparator.compare(words[i - 1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    private static class AlienLanguageComparator implements Comparator<String> {
        final int[] characterOrder = new int[26];

        AlienLanguageComparator(String order) {
            for (int index = 0 ; index < 26 ; index++) {
                characterOrder[order.charAt(index) - 'a'] = index;
            }
        }

        @Override
        public int compare(String s1, String s2) {
            if (s1.length() == s2.length() && s1.equals(s2)) return 0;
            for (int i = 0, j = 0 ; i < s1.length() && j < s2.length() ; i++, j++) {
                if (characterOrder[s1.charAt(i) - 'a'] < characterOrder[s2.charAt(j) - 'a']) return -1;
                else if (characterOrder[s1.charAt(i) - 'a'] > characterOrder[s2.charAt(j) - 'a']) return 1;
            }
            return s1.length() - s2.length();
        }
    }
}
