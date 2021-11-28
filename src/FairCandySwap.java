import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        final int difference = Arrays.stream(aliceSizes).sum() - Arrays.stream(bobSizes).sum();
        final int required = difference / 2;
        Set<Integer> bobCandies = new HashSet<>();
        for (int candy : bobSizes) bobCandies.add(candy);
        for (int candy : aliceSizes) {
            if (bobCandies.contains(candy - required)) return new int[] {candy, candy - required};
        }
        return new int[] {};
    }
}
