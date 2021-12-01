public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        for (int index = 0, level = 0 ; index < s.length() ; index++) {
            if (level != 0 && (level != -1 || s.charAt(index) != ')')) {
                result.append(s.charAt(index));
            }
            if (s.charAt(index) == '(') level--;
            else level++;
        }
        return result.toString();
    }
}
