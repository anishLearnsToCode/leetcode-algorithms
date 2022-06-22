// https://leetcode.com/problems/design-add-and-search-words-data-structure
// S: O(sum |word|_i)
/*
    trie.add(String word)
    T: O(word)

    trie.contains(String word)
    T: O(26^3 * word) = O(k * word) = O(word)
 */
/*
    word_dict.addWord(String word)
    T: O(word)

    word_dict.search(String word)
    T: O(word)
 */

import java.util.HashSet;
import java.util.Set;

public class DesignAddAndSearchWordsDataStructure {
    private static final class WordDictionary {

        private final Trie trie = new Trie();
        private final Set<String> words = new HashSet<>();

        public void addWord(String word) {
            words.add(word);
            trie.add(word);
        }

        public boolean search(String word) {
            if (!containsDots(word)) return words.contains(word);
            return trie.contains(word);
        }

        private boolean containsDots(String word) {
            for (int i = 0 ; i < word.length() ; i++) {
                if (word.charAt(i) == '.') return true;
            }
            return false;
        }
    }

    private static final class Trie {
        final Trie[] children = new Trie[26];
        boolean isWord = false;

        public void add(String s) {
            add(s, 0);
        }

        private void add(String s, int index) {
            if (index == s.length()) {
                isWord = true;
                return;
            }
            char c = s.charAt(index);
            if (children[c - 'a'] == null) children[c - 'a'] = new Trie();
            children[c - 'a'].add(s, index + 1);
        }

        public boolean contains(String s) {
            return contains(s, 0);
        }

        private boolean contains(String s, int index) {
            if (index == s.length()) return isWord;
            char character = s.charAt(index);
            if (character != '.') {
                return children[character - 'a'] != null && children[character - 'a'].contains(s, index + 1);
            }
            for (Trie child : children) {
                if (child != null && child.contains(s, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
