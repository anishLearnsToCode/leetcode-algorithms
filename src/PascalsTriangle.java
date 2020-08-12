import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int row = 1 ; row < numRows ; row++) {
            List<Integer> list = new ArrayList<>(row + 1);
            List<Integer> previous = result.get(result.size() - 1);
            list.add(1);
            for (int j = 1 ; j < row ; j++) {
                list.add(previous.get(j - 1) + previous.get(j));
            }
            list.add(1);
            result.add(list);
        }

        return result;
    }
}
