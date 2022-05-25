// https://leetcode.com/problems/implement-trie-prefix-tree
// insertion
// T: O(n)
// S: O(n)
// search
// T: O(n)
// S: O(n)
// starts with
// T: O(n)
// S: O(n)

public class Trie {
    private final Trie[] alphabet = new Trie[26];
    private boolean isWordEnd = false;

    public Trie() { }

    public void insert(String word) {
        insert(word, 0);
    }

    private void insert(String word, int index) {
        if (index == word.length()) {
            this.isWordEnd = true;
            return;
        }
        int charIndex = toIndex(word.charAt(index));
        if (alphabet[charIndex] == null) {
            alphabet[charIndex] = new Trie();
        }
        alphabet[charIndex].insert(word, index + 1);
    }

    public boolean search(String word) {
        return search(word, 0);
    }

    public boolean search(String word, int index) {
        if (index == word.length()) return isWordEnd;
        int charIndex = toIndex(word.charAt(index));
        if (alphabet[charIndex] == null) return false;
        return alphabet[charIndex].search(word, index + 1);
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
    }

    public boolean startsWith(String prefix, int index) {
        if (index == prefix.length()) return true;
        int charIndex = toIndex(prefix.charAt(index));
        if (alphabet[charIndex] == null) return false;
        return alphabet[charIndex].startsWith(prefix, index + 1);
    }

    private int toIndex(char c) {
        return c - 'a';
    }
}
