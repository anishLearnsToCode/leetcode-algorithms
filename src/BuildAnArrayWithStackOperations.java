import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
    private static final String PUSH = "Push";
    private static final String POP = "Pop";

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        for (int index = 0, lastNumber = 0 ; index < target.length ; index++) {
            popKNumbers(result, target[index] - 1 - lastNumber);
            pushCurrentNumber(result);
            lastNumber = target[index];
        }
        return result;
    }

    private void popKNumbers(List<String> list, int k) {
        while (k-- > 0) {
            list.add(PUSH);
            list.add(POP);
        }
    }

    private void pushCurrentNumber(List<String> list) {
        list.add(PUSH);
    }
}
