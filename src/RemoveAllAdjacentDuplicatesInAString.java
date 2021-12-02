import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInAString {

    public String removeDuplicates(String s) {
        final Stack<Character> stack = new Stack<>();
        int k, count = 0;
        stack.push(s.charAt(0));
        for (int index = 1 ; index < s.length() ; index = k + 1, count = 0) {
            for (k = index ; k + 1 < s.length() && s.charAt(k + 1) == s.charAt(k) ; k++);
            if (!stack.isEmpty() && stack.peek() == s.charAt(k)) {
                for (count = 0 ; !stack.isEmpty() && stack.peek() == s.charAt(k) ; count++) {
                    stack.pop();
                }
            }
            if (((k - index + 1 + count) & 1) == 1) stack.push(s.charAt(k));
        }
        StringBuilder result = getCharactersFrom(stack);
        return result.reverse().toString();
    }

    private StringBuilder getCharactersFrom(Stack<Character> stack) {
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result;
    }
}
