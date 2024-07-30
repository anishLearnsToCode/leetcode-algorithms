// https://leetcode.com/problems/word-ladder
// T: O(nB + n^m * nm)
// S: O(nB + n^m)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    private record Info(String string, int steps) {}

    // n = possible chars, m = |s|
    // V = n^m
    // BFS, T: O(V + E) = O(nB + n^m * nm), S: O(n^m)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }

        final Queue<Info> queue = new LinkedList<>() {{ add(new Info(beginWord, 0)); }};
        final Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            final Info info = queue.poll();
            if (visited.contains(info.string)) {
                continue;
            }
            visited.add(info.string);
            if (endWord.equals(info.string)) {
                return info.steps + 1;
            }

            for (String neighbour : validMutations(words, info.string)) {
                queue.add(new Info(neighbour, info.steps + 1));
            }
        }

        return -1;
    }

    // T: O(n * m), S: O(n * m)
    private static List<String> validMutations(Set<String> words, String string) {
        final List<String> list = new ArrayList<>();
        for (int i = 0 ; i < string.length() ; i++) {
            for (char c = 'a' ; c <= 'z' ; c++) {
                final String word = string.substring(0, i) + c + string.substring(i + 1);
                if (words.contains(word)) {
                    list.add(word);
                }
            }
        }
        return list;
    }
}
