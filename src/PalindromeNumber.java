// https://leetcode.com/problems/palindrome-number/

import java.util.Scanner;

public class PalindromeNumber {

    public boolean isPalindrome(int number) {
        if (number < 0 || (number % 10 == 0 && number != 0)) {
            return false;
        }
        int reverse = 0;
        while (number > reverse) {
            reverse = 10 * reverse + number % 10;
            number /= 10;
        }
        return number == reverse || number == reverse / 10;
    }
}
