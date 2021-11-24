import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int number = left ; number <= right ; number++) {
            if (isSefDividing(number)) {
                result.add(number);
            }
        }
        return result;
    }

    private boolean isSefDividing(int number) {
        int original = number, digit;
        while (number > 0) {
            digit = number % 10;
            if (digit == 0 || original % digit != 0) return false;
            number /= 10;
        }
        return true;
    }
}
