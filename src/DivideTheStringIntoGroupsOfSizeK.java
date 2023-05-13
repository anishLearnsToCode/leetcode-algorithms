// https://leetcode.com/problems/divide-a-string-into-groups-of-size-k
// T: O(s)
// S: O(s)

public class DivideTheStringIntoGroupsOfSizeK {
    public String[] divideString(String s, int k, char fill) {
        final String filler = fill + "";
        final int groups = (int) Math.ceil((double) s.length() / k);
        final String[] result = new String[groups];

        for (int i = 0 ; i < groups ; i++) {
            if (i == result.length - 1) {
                if (s.length() - k * i < k) result[i] = s.substring(k * i) + filler.repeat(k - s.length() + k * i);
                else result[i] = s.substring(k * i);
            } else {
                result[i] = s.substring(k * i, k * i + k);
            }
        }

        return result;
    }
}
