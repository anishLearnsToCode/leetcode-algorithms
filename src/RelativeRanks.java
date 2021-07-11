import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelativeRanks {
    static class Pair {
        private final int index;
        private final int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }

    private static List<Pair> getValuesWithIndex(int[] array) {
        List<Pair> result = new ArrayList<>();
        for (int index = 0 ; index < array.length ; index++) {
            result.add(new Pair(index, array[index]));
        }
        return result;
    }

    private static Map<Integer, Integer> getValueToIndexMap(List<Pair> array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int index = 0 ; index < array.size() ; index++) {
            result.put(array.get(index).value, index);
        }
        return result;
    }

    private static String getRank(int position) {
        switch (position) {
            case 1: return "Gold Medal";
            case 2: return "Silver Medal";
            case 3: return "Bronze Medal";
            default: return position + "";
        }
    }

    public static String[] findRelativeRanks(int[] score) {
        List<Pair> sortedScores = getValuesWithIndex(score);
        sortedScores.sort(((o1, o2) -> Integer.compare(o2.value, o1.value)));
        System.out.println(sortedScores);
        Map<Integer, Integer> value2index = getValueToIndexMap(sortedScores);
        String[] result = new String[score.length];
        for (int index = 0 ; index < score.length ; index++) {
            result[index] = getRank(value2index.get(score[index]) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }
}
