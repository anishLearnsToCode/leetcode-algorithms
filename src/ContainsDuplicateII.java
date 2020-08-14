import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));
    }

//    private static class Frequency {
//        private static final Map<Integer, Integer> frequency = new HashMap<>();
//
//        public static Frequency withWindowSize(int[] array, int window) {
//            Frequency frequency = new Frequency();
//            for (int index = 0 ; index < window ; index++) {
//                frequency.add(array[index]);
//            }
//            return frequency;
//        }
//
//        public void add(int element) {
//            frequency.put(element, frequency.getOrDefault(element, 0) + 1);
//        }
//
//        public void remove(int element) {
//            if (contains(element)) {
//                frequency.put(element, frequency.get(element) - 1);
//            }
//        }
//
//        public boolean contains(int element) {
//            return frequency.getOrDefault(element, 0) > 0;
//        }
//    }
//
//    public static boolean containsNearbyDuplicate(int[] array, int k) {
//        Frequency slidingWindow = Frequency.withWindowSize(array, k);
//        for (int index = k ; index < array.length ; index++) {
//            if (slidingWindow.contains(array[index])) {
//                return true;
//            }
//            slidingWindow.add(array[index]);
//            slidingWindow.remove(array[index - k]);
//        }
//        return false;
//    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> checkForDuplicatesSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int preSize = checkForDuplicatesSet.size();
            int currentNum = nums[i];
            checkForDuplicatesSet.add(currentNum);
            if (checkForDuplicatesSet.size() == preSize) {
                int dupK = k, reverse = i - 1;
                while ( dupK > 0) {
                    if ( nums[reverse] == currentNum) {
                        return true;
                    }
                    dupK--;
                    reverse--;
                }
            }
        }
        return false;
    }
}
