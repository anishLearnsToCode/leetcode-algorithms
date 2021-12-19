public class GoalParserInterpretation {
    public String interpret(String command) {
        final StringBuilder result = new StringBuilder();
        for (int index = 0 ; index < command.length() ; ) {
            if (command.charAt(index) == 'G') {
                result.append('G');
                index++;
            } else if (command.charAt(index + 1) == ')') {
                result.append('o');
                index += 2;
            } else {
                result.append("al");
                index += 4;
            }
        }
        return result.toString();
    }
}
