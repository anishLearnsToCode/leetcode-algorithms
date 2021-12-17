import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorInACircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        final int start = rounds[0], end = rounds[rounds.length - 1];
        final List<Integer> result = new ArrayList<>();
        if (start <= end) {
            for (int i = start ; i <= end ; i++) {
                result.add(i);
            }
            return result;
        }
        for (int i = 1; i <= end ; i++) result.add(i);
        for (int i = start ; i <= n ; i++) result.add(i);
        return result;
    }
}
