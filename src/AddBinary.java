import java.util.Scanner;

public class AddBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bin1 = scanner.next();
        String bin2 = scanner.next();
        System.out.println(addBinary(bin1, bin2));
    }

    public static String addBinary(String a, String b) {
        Binary number1 = new Binary(a);
        Binary number2 = new Binary(b);
        return number1.add(number2).toString();
    }

    private static class Binary {
        private final String number;

        Binary(String number) {
            this.number = number;
        }

        public int get(int index) {
            index = number.length() - index - 1;
            if (index < 0) {
                return 0;
            }
            return number.charAt(index) - 48;
        }

        public int length() {
            return this.number.length();
        }

        public Binary add(Binary other) {
            StringBuilder result = new StringBuilder();
            int carry = 0;
            for (int index = 0 ; index < Math.max(length(), other.length()) ; index++) {
                int value = this.get(index) + other.get(index) + carry;
                result.append(value % 2);
                carry = value / 2;
            }
            if (carry > 0) {
                result.append(carry);
            }
            return new Binary(result.reverse().toString());
        }

        @Override
        public String toString() {
            return this.number;
        }
    }
}
