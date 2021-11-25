import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelTypes = toSet(jewels);
        int totalJewels = 0;
        for (char stone : stones.toCharArray()) {
            if (jewelTypes.contains(stone)) {
                totalJewels++;
            }
        }
        return totalJewels;
    }

    private Set<Character> toSet(String string) {
        Set<Character> set = new HashSet<>();
        for (char character : string.toCharArray()) {
            set.add(character);
        }
        return set;
    }
}
