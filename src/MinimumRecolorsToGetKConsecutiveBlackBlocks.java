// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks
// T: O(N)
// S: O(1)

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public int minimumRecolors(String blocks, int k) {
        int numberOfWhites = numberOfWhitesInFirst(blocks, k);
        int minRecolors = numberOfWhites;

        for (int index = k ; index < blocks.length() ; index++) {
            if (blocks.charAt(index - k)== 'W') numberOfWhites--;
            if (blocks.charAt(index) == 'W') numberOfWhites++;
            minRecolors = Math.min(minRecolors, numberOfWhites);
        }

        return minRecolors;
    }

    private int numberOfWhitesInFirst(String blocks, int k) {
        int result = 0;
        for (int index = 0 ; index < k ; index++) {
            if (blocks.charAt(index) == 'W') result++;
        }
        return result;
    }
}
