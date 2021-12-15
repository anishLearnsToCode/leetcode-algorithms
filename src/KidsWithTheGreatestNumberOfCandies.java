import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        final List<Boolean> result = new ArrayList<>();
        final int maxCandies = Arrays.stream(candies).max().getAsInt();
        for (int person : candies) {
            result.add(person + extraCandies >= maxCandies);
        }
        return result;
    }
}
