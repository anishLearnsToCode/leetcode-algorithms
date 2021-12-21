import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBallsInABox {
    public int countBalls(int lowLimit, int highLimit) {
        final Map<Integer, Integer> boxes = new HashMap<>();
        for (int ball = lowLimit ; ball <= highLimit ; ball++) {
            int boxNumber = sumOfDigits(ball);
            boxes.put(boxNumber, boxes.getOrDefault(boxNumber, 0) + 1);
        }
        return boxes.values().stream().max(Integer::compareTo).get();
    }

    private int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
