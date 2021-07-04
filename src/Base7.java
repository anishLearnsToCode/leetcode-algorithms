public class Base7 {
    public static String convertToBase7(int number) {
        if (number == 0) return "0";
        StringBuilder result = new StringBuilder();
        boolean isNegative = number < 0;
        if (isNegative) {
            number *= -1;
        }
        while (number > 0) {
            result.append(number % 7);
            number /= 7;
        }
        return result.append(isNegative ? "-" : "").reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(-7));
    }
}
