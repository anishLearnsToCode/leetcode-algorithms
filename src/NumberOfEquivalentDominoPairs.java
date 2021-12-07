import java.util.HashMap;
import java.util.Map;

public class NumberOfEquivalentDominoPairs {
    private static class Domino {
        private final int number;

        Domino(int[] array) {
            number = Math.min(array[0], array[1]) * 10 + Math.max(array[0], array[1]);
        }

        @Override
        public boolean equals(Object o) {
            Domino domino = (Domino) o;
            return number == domino.number;
        }

        @Override
        public int hashCode() {
            return number;
        }
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        final Map<Domino, Integer> dominoesFrequencies = new HashMap<>();
        Domino d;
        for (int[] domino : dominoes) {
            d = new Domino(domino);
            dominoesFrequencies.put(d, dominoesFrequencies.getOrDefault(d, 0) + 1);
        }
        int equivalentPairs = 0;
        for (int frequency : dominoesFrequencies.values()) {
            equivalentPairs += (frequency * (frequency - 1)) / 2;
        }
        return equivalentPairs;
    }
}
