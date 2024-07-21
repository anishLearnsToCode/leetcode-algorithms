// https://leetcode.com/problems/alternating-groups-i
// T: O(N)
// S: O(1)

public class AlternatingGroupsI {
    public int numberOfAlternatingGroups(int[] colors) {
        int groups = 0;
        for (int i = 0 ; i < colors.length ; i++) {
            if (isAlternating(colors, i)) {
               groups++;
            }
        }
        return groups;
    }
    private static boolean isAlternating(int[] colors, int startIndex) {
        return colors[startIndex] == colors[(startIndex + 2) % colors.length] &&
                colors[startIndex] != colors[(startIndex + 1) % colors.length]
    }
}
