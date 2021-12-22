import java.util.LinkedList;
import java.util.Queue;

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        final Queue<Integer> differencesIndex = new LinkedList<>();
        for (int i = 0 ; i < s1.length() ; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differencesIndex.add(i);
            }
        }
        return differencesIndex.size() == 0 || (differencesIndex.size() == 2 && areSameChars(s1, s2, differencesIndex));
    }

    private boolean areSameChars(String s1, String s2, Queue<Integer> differenceIndexes) {
        final int i = differenceIndexes.poll() , j = differenceIndexes.poll();
        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }
}
