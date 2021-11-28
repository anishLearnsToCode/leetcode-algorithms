public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String s) {
        StringBuilder result = new StringBuilder();
        int tail = s.length() - 1;
        while (tail >= 0 && !Character.isAlphabetic(s.charAt(tail))) tail--;

        for (int head = 0 ; head < s.length() ; head++) {
            if (Character.isAlphabetic(s.charAt(head))) {
                result.append(s.charAt(tail--));
                while (tail >=0 && !Character.isAlphabetic(s.charAt(tail))) tail--;
            } else result.append(s.charAt(head));
        }

        return result.toString();
    }
}
