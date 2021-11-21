import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    private String getRangeString(int start, int end) {
        return end == start ? start + "" : start + "->" + end;
    }

    public List<String> summaryRanges(int[] array) {
        if (array.length == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        for (int index = 1 ; index < array.length ; index++) {
            if (array[index] > array[startIndex] + (index - startIndex)) {
                result.add(getRangeString(array[startIndex], array[index - 1]));
                startIndex = index;
            }
        }
        result.add(getRangeString(array[startIndex], array[array.length - 1]));
        return result;
    }
}
