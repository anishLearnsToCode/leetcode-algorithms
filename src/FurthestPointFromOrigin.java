// https://leetcode.com/problems/furthest-point-from-origin
// T: O(N)
// S: O(1)

public class FurthestPointFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        final int numberOfLeftMoves = numberOf(moves, 'L');
        final int numberOfRightMoves = numberOf(moves, 'R');
        final int numberOfFreeMoves = numberOf(moves, '_');

        return Math.abs(numberOfLeftMoves - numberOfRightMoves) + numberOfFreeMoves;
    }

    private static int numberOf(final String moves, final char c) {
        int count = 0;
        for (int i = 0 ; i < moves.length() ; i++) {
            if (moves.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
