import java.util.Arrays;

public class Heaters {
    private static int binarySearch(int[] array, int element) {
        int left = 0, right = array.length - 1, middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (array[middle] == element) return middle;
            else if (array[middle] < element) left = middle + 1;
            else right = middle - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(findRadius(new int[] {1, 2, 3, 4}, new int[] {1, 4}));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int minRadius = 0, leftRadius, rightRadius;
        for (int house : houses) {
            int index = binarySearch(heaters, house);
            if (index < heaters.length && house == heaters[index]) {
                continue;
            }
            leftRadius = index > 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            rightRadius = (index == heaters.length ? Integer.MAX_VALUE : heaters[index] - house);
            minRadius = Math.max(minRadius, Math.min(leftRadius, rightRadius));
        }
        return minRadius;
    }
}
