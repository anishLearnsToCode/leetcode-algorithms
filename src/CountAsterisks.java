// https://leetcode.com/problems/count-asterisks
// T: O(|s|)
// S: O(1)

public class CountAsterisks {
    public int countAsterisks(String s) {
        boolean seenPipe = false;
        int count = 0, pipeBuffer = 0;

        for (int index = 0 ; index < s.length() ; index++) {
            if (s.charAt(index) == '|') {
                if (seenPipe) {
                    pipeBuffer = 0;
                }
                seenPipe = !seenPipe;
            }

            if (s.charAt(index) == '*') {
                if (seenPipe) pipeBuffer++;
                else count++;
            }
        }

        return count + pipeBuffer;
    }
}
