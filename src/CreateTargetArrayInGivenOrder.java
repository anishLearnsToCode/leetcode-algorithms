import java.util.ArrayList;
import java.util.List;

public class CreateTargetArrayInGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < index.length ; i++) {
            result.add(index[i], nums[i]);
        }
        return toArray(result);
    }

    private int[] toArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = list.get(index);
        }
        return array;
    }
}
