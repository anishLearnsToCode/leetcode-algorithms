import java.util.Arrays;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] customer : accounts) {
            maxWealth = Math.max(maxWealth, Arrays.stream(customer).sum());
        }
        return maxWealth;
    }
}
