import java.util.*;

public class HelloWorld {
    public static List<List<Integer>> buyVolumes(List<Integer> volumes) {
        if (volumes.isEmpty()) {
            return new ArrayList<>();
        }

        final List<List<Integer>> result = new ArrayList<>();
        int max = 0, required = 1, elements = 0;
        boolean found = false;
        for (int volumeNumber : volumes) {
            max = Math.max(max, volumeNumber);
            elements++;
            if (volumeNumber == required) {
                found = true;
            }
            if (found) {
                if (elements == max - required + 1) {
                    result.add(sorted(required, max));
                    elements = 0;
                    required = max + 1;
                    found = false;
                } else {
                    result.add(List.of(-1));
                }
            } else {
                result.add(List.of(-1));
            }
        }
        return result;
    }

    private static List<Integer> sorted(int start, int end) {
        final List<Integer> result = new ArrayList<>();
        for (int element = start ; element <= end ; element++) {
            result.add(element);
        }
        return result;
    }

    private static List<Long> hello(List<Integer> prices, List<Integer> start, List<Integer> end, List<Integer> querries) {
        final Map<Integer, Long> orderPrices = getPricesFrequency(prices, start, end);
        final long[][] pairs = createPairs(orderPrices);
        final List<Long> result = new ArrayList<>();
        for (int query : querries) {
            final int index = binarySearch(pairs, query - 1);
            if (pairs[index][0] == query - 1) {
                result.add(pairs[index][1]);
            } else {
                result.add(pairs[index - 1][1]);
            }
        }
        return result;
    }

    private static Map<Integer, Long> getPricesFrequency(List<Integer> prices, List<Integer> start, List<Integer> end) {
        final Map<Integer, Long> result = new HashMap<>();
        final int queries = start.size();
        for (int i = 0 ; i < queries ; i++) {
            final int startIndex = start.get(i), endIndex = end.get(i);
            addToFrequencies(result, prices, startIndex, endIndex);
        }
        return result;
    }

    private static void addToFrequencies(Map<Integer, Long> frequencies, List<Integer> prices, int start, int end) {
        for (int i = start ; i <= end ; i++) {
            frequencies.put(prices.get(i), frequencies.getOrDefault(prices.get(i), 0L) + 1);
        }
    }

    private static long[][] createPairs(Map<Integer, Long> frequencies) {
        final long[][] result = new long[frequencies.size()][2];
        int k = 0;
        for (Map.Entry<Integer, Long> entry : frequencies.entrySet()) {
            result[k++] = new long[] {entry.getKey(), entry.getValue()};
        }
        for (int i = 1 ; i < result.length ; i++) {
            result[i][1] += result[i - 1][1];
        }
        Arrays.sort(result, Comparator.comparingLong(a -> a[0]));
        return result;
    }

    private static int binarySearch(long[][] array, int x) {
        int left = 0, right = array.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle][0] == x) return middle;
            else if (array[middle][0] < x) left = middle + 1;
            else right = middle - 1;
        }
        return left;
    }
 }
