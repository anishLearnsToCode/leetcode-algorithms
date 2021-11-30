import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int sum;
        for (int i = num.length - 1, carry = 0 ; i >= 0 || carry > 0 || k > 0 ; i--, k /= 10) {
            sum = get(num, i) + carry + k % 10;
            result.add(sum % 10);
            carry = sum / 10;
        }
        Collections.reverse(result);
        return result;
    }

    private int get(int[] array, int index) {
        if (index < 0) return 0;
        return array[index];
    }
}
