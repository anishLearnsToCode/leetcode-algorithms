// https://leetcode.com/problems/compare-version-numbers
// T: O(|v1| + |v2|)
// S: O(v1 + v2)

import java.util.ArrayList;
import java.util.List;

public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        final List<Integer> revisions1 = getRevisions(version1);
        final List<Integer> revisions2 = getRevisions(version2);
        return compareVersion(revisions1, revisions2);
    }

    public static int compareVersion(List<Integer> version1, List<Integer> version2) {
        int length = Math.max(version1.size(), version2.size());
        for (int i = 0 ; i < length ; i++){
            if (get(version1, i) < get(version2, i)) return -1;
            else if (get(version1, i) > get(version2, i)) return 1;
        }
        return 0;
    }

    private static int get(List<Integer> list, int index) {
        if (index >= list.size()) return 0;
        return list.get(index);
    }

    private static List<Integer> getRevisions(String version) {
        final String[] revisions = version.split("\\.");
        final List<Integer> result = new ArrayList<>();
        for (String revision : revisions) {
            result.add(Integer.parseInt(revision));
        }
        return result;
    }
}
