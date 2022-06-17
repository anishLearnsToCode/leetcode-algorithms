import java.util.List;

public class WordBreak {
    private static final class Trie {
        private static final int LETTERS_IN_ENGLISH_ALPHABET = 26;

        Trie[] letters = new Trie[LETTERS_IN_ENGLISH_ALPHABET];
        boolean isWord = false;

        public void insert(String word) {
            insert(word, 0, this);
        }

        private void insert(String s, int index, Trie root) {
            if (index >= s.length()) {
                root.isWord = true;
                return;
            }
            if (root.letters[s.charAt(index) - 'a'] == null) {
                root.letters[s.charAt(index) - 'a'] = new Trie();
            }
            insert(s, index + 1, root.letters[s.charAt(index) - 'a']);
        }

        public boolean exists(String word) {
            return exists(word, 0, this);
        }

        private boolean exists(String s, int index, Trie root) {
            if (index >= s.length()) {
                return root.isWord;
            }
            if (root.letters[s.charAt(index) - 'a'] == null) return false;
            return exists(s, index + 1, root.letters[s.charAt(index) - 'a']);
        }
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        final Trie trie = new Trie();
        for (String string : wordDict) {
            trie.insert(string);
        }
        return wordBreak(s, trie);
    }

    private boolean wordBreak(String s, Trie root) {
        if (s.isEmpty()) return true;

        for (int i = 0 ; i < s.length() ; i++) {
            if (root.exists(s.substring(0, i + 1)) && wordBreak(s.substring(i + 1), root)) {
                return true;
            }
        }

        return false;
    }
}
