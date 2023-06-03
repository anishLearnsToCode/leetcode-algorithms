// https://leetcode.com/problems/minimum-common-value
// T: O(m + n)
// S: O(1)

public class MinimumCommonValue {
    public int getCommon(int[] array1, int[] array2) {
        for (int i = 0, j = 0 ; i < array1.length && j < array2.length ; ) {
            if (array1[i] == array2[j]) return array1[i];

            if (array1[i] < array2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
}
