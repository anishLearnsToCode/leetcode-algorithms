public class CheckIfAll1sAreAtLeastKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int index = 0;
        while (index < nums.length && nums[index] != 1) index++;
        index++;
        for ( int distance = 0 ; index < nums.length ; index++) {
            if (nums[index] == 1) {
                if (distance < k) return false;
                distance = 0;
            } else distance++;
        }
        return true;
    }
}
