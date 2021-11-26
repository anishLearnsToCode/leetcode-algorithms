import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        char current = s.charAt(0);
        int start = 0;
        for (int index = 1 ; index < s.length() ; index++) {
            if (s.charAt(index) != current) {
                if (index - start >= 3) result.add(List.of(start, index - 1));
                start = index;
                current = s.charAt(index);
            }
        }
        if (s.length() - start >= 3) result.add(List.of(start, s.length() - 1));
        return result;
    }
}
