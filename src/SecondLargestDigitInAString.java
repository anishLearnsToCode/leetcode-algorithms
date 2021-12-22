public class SecondLargestDigitInAString {
    public int secondHighest(String s) {
        int largestDigit =  -1, secondLargestDigit = -1;
        for (int index = 0 ; index < s.length() ; index++) {
            if (Character.isDigit(s.charAt(index))) {
                int digit = s.charAt(index) - '0';
                if (digit > largestDigit) {
                    int temp = largestDigit;
                    largestDigit = digit;
                    secondLargestDigit = temp;
                } else if (digit < largestDigit && digit > secondLargestDigit) {
                    secondLargestDigit = digit;
                }
            }
        }
        return secondLargestDigit;
    }
}
