import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (long index = 1, value = 1; index < rowIndex + 1 ; index++) {
            value = (value * (rowIndex - index + 1)) / (index);
            result.add((int) value);
        }
        return result;
    }
}
