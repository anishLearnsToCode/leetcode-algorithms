import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceToTheTargetElement {
    public int getMinDistance(int[] nums, int target, int start) {
        final List<Integer> indexes = getIndexes(nums, target);
        final int position = search(indexes, start);
        if (position >= indexes.size()) return start - indexes.get(position - 1);
        if (indexes.get(position) == start) return 0;
        if (position == 0) return indexes.get(position) - start;
        return Math.min(indexes.get(position) - start, start - indexes.get(position - 1));
    }

    private List<Integer> getIndexes(int[] array, int target){
        final List<Integer> indexes = new ArrayList<>();
        for (int index = 0 ; index < array.length ; index++) {
            if (array[index] == target) {
                indexes.add(index);
            }
        }
        return indexes;
    }

    private int search(List<Integer> array, int x) {
        int left = 0, right = array.size() - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array.get(middle) == x) return middle;
            else if (array.get(middle) > x) right = middle - 1;
            else left = middle + 1;
        }
        return left;
    }
}
