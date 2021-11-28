import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) return false;
        Map<Integer, Integer> cards = getFrequencies(deck);
        Set<Integer> frequencies = new HashSet<>(cards.values());
        if (frequencies.size() == 1 && cards.get(deck[0]) >= 2) return true;
        return gcd(frequencies) > 1;
    }

    private int gcd(Collection<Integer> collection) {
        int gcd = 0;
        boolean firstTime = true;
        for (int value : collection) {
            gcd = firstTime ? value : gcd(gcd, value);
            firstTime = false;
        }
        return gcd;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int val : array) {
            result.put(val, result.getOrDefault(val, 0) + 1);
        }
        return result;
    }
}
