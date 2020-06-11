// https://leetcode.com/problems/reverse-integer/

import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(reverse(number));
    }

    private static int reverse(int number) {
        boolean isPositive = number >= 0;
        StringBuilder accumulator = new StringBuilder(number + "");
        if (!isPositive) {
            accumulator.replace(0, 1, "");
        }
        try {
            return Integer.parseInt(accumulator.reverse().insert(0, isPositive ? "" : "-").toString());
        } catch (NumberFormatException exception) {
            return 0;
        }
    }
}
