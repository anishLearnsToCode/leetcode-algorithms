import java.util.TreeMap;

public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] array, int k, int t) {
        // no memory
        if (k == 0) return false;

        final TreeMap<Long, Integer> elements = new TreeMap<>();
        for (int i = 0 ; i < array.length ; i++) {
            long lowerBound = (long) array[i] - t;
            long upperBound = (long) array[i] + t;
            long lowerClosest = getClosestOrHigher(elements, lowerBound);
            if (inRange(lowerClosest, lowerBound, upperBound)) return true;
            long upperClosest = getClosestOrLower(elements, upperBound);
            if (inRange(upperClosest, lowerBound, upperBound)) return true;
            if (i >= k) {
                removeFromMap(elements, array[i - k]);
            }
            addToMap(elements, array[i]);
        }

        return false;
    }

    private void removeFromMap(TreeMap<Long, Integer> elements, long val) {
        if (elements.get(val) == 1) {
            elements.remove(val);
        } else {
            elements.put(val, elements.get(val) - 1);
        }
    }

    private void addToMap(TreeMap<Long, Integer> elements, long val) {
        elements.put(val, elements.getOrDefault(val, 0) + 1);
    }

    private long getClosestOrHigher(TreeMap<Long, Integer> elements, long val) {
        Long lowerClosest = elements.ceilingKey(val);
        return lowerClosest == null ? Long.MAX_VALUE : lowerClosest;
    }

    private long getClosestOrLower(TreeMap<Long, Integer> elements, long val) {
        Long upperClosest = elements.floorKey(val);
        return upperClosest == null ? Long.MIN_VALUE : upperClosest;
    }

    private boolean inRange(long val, long low, long high) {
        return low <= val && val <= high;
    }
}
