// https://leetcode.com/problems/flip-game
// N = |currentState|
// T: O(N^2)
// S: O(N^2)

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String currentState) {
        final List<String> result = new ArrayList<>();
        for (int i = 0 ; i < currentState.length() - 1 ; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                result.add(flip(currentState, i));
            }
        }
        return result;
    }

    private static String flip(String state, int index) {
        return state.substring(0, index) + "--" + state.substring(index + 2);
    }
}
