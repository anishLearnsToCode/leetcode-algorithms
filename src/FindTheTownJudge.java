import java.util.HashMap;
import java.util.Map;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> inDegreeTrust = new HashMap<>();
        Map<Integer, Integer> outDegreeTrust = new HashMap<>();
        for (int[] person : trust) {
            inDegreeTrust.put(person[1], inDegreeTrust.getOrDefault(person[1], 0) + 1);
            outDegreeTrust.put(person[0], inDegreeTrust.getOrDefault(person[0], 0) + 1);
        }
        for (int i = 1 ; i <= n ; i++) {
            if (outDegreeTrust.getOrDefault(i, 0) == 0 && inDegreeTrust.getOrDefault(i, 0) == n - 1)
                return i;
        }
        return -1;
    }
}
