// https://leetcode.com/problems/apple-redistribution-into-boxes
// N = |apples|, M = |capacity|
// T: O(N + M log(M))
// S: O(log(M))

import java.util.Arrays;

public class AppleRedistributionIntoBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = Arrays.stream(apple).sum();
        Arrays.sort(capacity);

        int boxesRequired = 0;
        for (int i = capacity.length - 1 ; i >= 0 ; i--) {
            if (totalApples <= 0) {
                break;
            }
            totalApples -= capacity[i];
            boxesRequired++;
        }
        return boxesRequired;
    }
}
