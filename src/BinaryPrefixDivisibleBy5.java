import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    private static final int[][] stateFlow = {
            {0, 1},
            {2, 3},
            {4, 0},
            {1, 2},
            {3, 4}
    };

    public List<Boolean> prefixesDivBy5(int[] binaryArray) {
        final List<Boolean> result = new ArrayList<>();
        int state = binaryArray[0];
        for (int index = 0 ; index < binaryArray.length - 1 ; index++) {
            result.add(state == 0);
            state = stateFlow[state][binaryArray[index + 1]];
        }
        result.add(state == 0);
        return result;
    }
}
