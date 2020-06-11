// https://leetcode.com/problems/palindrome-number/

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(isPalindrome(number));
    }

    private static boolean isPalindrome(int number) {
        String representation = number + "";
        for (int index = 0 ; index < representation.length() / 2 ; index++) {
            if (representation.charAt(index) != representation.charAt(representation.length() - 1 - index)) {
                return false;
            }
        }
        return true;
    }
}
