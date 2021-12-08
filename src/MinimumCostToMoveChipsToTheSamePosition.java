public class MinimumCostToMoveChipsToTheSamePosition {
    public int minCostToMoveChips(int[] positions) {
        int evenPositionChips = 0;
        for (int position : positions) {
            if (position % 2 == 0) evenPositionChips++;
        }
        return Math.min(evenPositionChips, positions.length - evenPositionChips);
    }
}
