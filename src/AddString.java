public class AddString {
    public static void main(String[] args) {
        String number1 = "5";
        String number2 = "10";
        System.out.println(addStrings(number1, number2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0, length = Math.max(num1.length(), num2.length());
        for (int index = 0 ; index < length ; index++) {
            int digit1 = getDigit(num1, index);
            int digit2 = getDigit(num2, index);
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        return result.append(carry > 0 ? carry : "").reverse().toString();
    }

    private static int getDigit(String number, int index) {
        if (index < number.length()) {
            return number.charAt(number.length() - index - 1) - '0';
        }
        return 0;
    }
}
