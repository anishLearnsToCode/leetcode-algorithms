// https://leetcode.com/problems/simplify-path
// T: O(|path|)
// S: O(|path|)

import java.util.LinkedList;

public class SimplifyPath {
    private static final char SLASH = '/';
    private static final String ROOT = "/";
    private static final String GO_ONE_LEVEL_UP = "..";
    private static final String STAY_WHERE_YOU_ARE = ".";

    public String simplifyPath(String path) {
        final LinkedList<StringBuilder> fragments = new LinkedList<>();
        StringBuilder current = new StringBuilder();
        for (int i = 0 ; i < path.length() ; i++) {
            if (path.charAt(i) == SLASH) {
                if (!isEmpty(current)) {
                    addToFragments(current, fragments);
                    current = new StringBuilder();
                }
            } else current.append(path.charAt(i));
        }
        if (!isEmpty(current)) addToFragments(current, fragments);
        return toPath(fragments);
    }

    private String toPath(LinkedList<StringBuilder> fragments) {
        if (fragments.isEmpty()) return ROOT;
        StringBuilder result = new StringBuilder();
        for (StringBuilder fragment : fragments) {
            result.append(SLASH).append(fragment);
        }
        return result.toString();
    }

    private void removeLast(LinkedList<StringBuilder> fragments) {
        if (!fragments.isEmpty()) {
            fragments.removeLast();
        }
    }

    private void addToFragments(StringBuilder current, LinkedList<StringBuilder> fragments) {
        String currentString = current.toString();
        if (GO_ONE_LEVEL_UP.equals(currentString)) {
            removeLast(fragments);
        } else if (!STAY_WHERE_YOU_ARE.equals(currentString)) {
            fragments.add(current);
        }
    }

    private boolean isEmpty(StringBuilder stringBuilder) {
        return stringBuilder.length() == 0;
    }
}
