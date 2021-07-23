import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int indexSum = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        Map<String, Integer> restaurantIndices = getValueToIndexMap(list1);
        for (int index = 0 ; index < list2.length ; index++) {
            if (restaurantIndices.containsKey(list2[index])) {
                if (index + restaurantIndices.get(list2[index]) < indexSum) {
                    result.clear();
                    result.add(list2[index]);
                    indexSum = index + restaurantIndices.get(list2[index]);
                } else if(index + restaurantIndices.get(list2[index]) == indexSum) {
                    result.add(list2[index]);
                }
            }
        }
        return toArray(result);
    }

    private String[] toArray(List<String> strings) {
        String[] result = new String[strings.size()];
        for (int index = 0 ; index < result.length ; index++) {
            result[index] = strings.get(index);
        }
        return result;
    }

    private Map<String, Integer> getValueToIndexMap(String[] array) {
        Map<String, Integer> result = new HashMap<>();
        for (int index = 0 ; index < array.length ; index++) {
            result.put(array[index], index);
        }
        return result;
    }
}
