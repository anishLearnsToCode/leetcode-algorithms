import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        final Map<Integer, Integer> positions = getPositions(arr);
        for (int[] piece : pieces) {
            if (!positions.containsKey(piece[0])) return false;
            if (positions.get(piece[0]) + piece.length > arr.length) return false;
            for (int i = 0, j = positions.get(piece[0]); i < piece.length ; i++, j++) {
                if (piece[i] != arr[j]) return false;
            }
        }
        return true;
    }

    private Map<Integer, Integer> getPositions(int[] array) {
        final Map<Integer, Integer> positions = new HashMap<>();
        for (int index = 0 ; index < array.length ; index++) {
            positions.put(array[index], index);
        }
        return positions;
    }
}
