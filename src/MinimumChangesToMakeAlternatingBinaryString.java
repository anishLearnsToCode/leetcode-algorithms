public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        return Math.min(
                    operationsToChangeIntoAlternatingString(s, '1'),
                    operationsToChangeIntoAlternatingString(s, '0')
                );
    }

    private int operationsToChangeIntoAlternatingString(String s, char start) {
        int changes = 0, current = start - '0';
        for (int index = 0 ; index < s.length() ; index++, current ^= 1) {
            if (s.charAt(index) != current + '0') changes++;
        }
        return changes;
    }
}
