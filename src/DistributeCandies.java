import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> candyTypes = new HashSet<>();
        for (int type : candyType) {
            candyTypes.add(type);
        }
        return Math.min(candyType.length / 2, candyTypes.size());
    }
}
