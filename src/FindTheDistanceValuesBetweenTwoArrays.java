import java.util.TreeSet;

public class FindTheDistanceValuesBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int number : arr2) {
            set.add(number);
        }
        int distanceValue = 0;
        for (int number : arr1) {
            if (smallerOrEqual(set, number) < number - d && largerOrEqual(set, number) > number + d) {
                distanceValue++;
            }
        }
        return distanceValue;
    }

    private int smallerOrEqual(TreeSet<Integer> set, int number) {
        if (set.contains(number)) return number;
        return valIfNull(set.lower(number), Integer.MIN_VALUE);
    }

    private int largerOrEqual(TreeSet<Integer> set, int number) {
        if (set.contains(number)) return number;
        return valIfNull(set.higher(number), Integer.MAX_VALUE);
    }

    private int valIfNull(Integer value, int defaultValue) {
        if (value == null) return defaultValue;
        return value;
    }
}
