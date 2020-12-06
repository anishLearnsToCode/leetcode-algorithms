// Problem Number: 455
// https://leetcode.com/problems/assign-cookies/

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contendedChildren = 0;
        for (int i= 0, j = 0 ; i < g.length && j < s.length ; j++) {
            if (s[j] >= g[i]) {
                contendedChildren++;
                i++;
            }
        }
        return contendedChildren;
    }
}
