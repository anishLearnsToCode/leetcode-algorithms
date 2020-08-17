public class ReverseString {
    public static void reverseString(char[] string) {
        for (int index = 0 ; index < string.length / 2 ; index++) {
            char temp = string[index];
            string[index] = string[string.length - index - 1];
            string[string.length - index - 1] = temp;
        }
    }
}
