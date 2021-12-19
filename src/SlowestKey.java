public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char slowestKey = keysPressed.charAt(0);
        int longestDuration = releaseTimes[0];
        for (int index = 1 ; index < keysPressed.length() ; index++) {
            if (releaseTimes[index] - releaseTimes[index - 1] > longestDuration) {
                longestDuration = releaseTimes[index] - releaseTimes[index - 1];
                slowestKey = keysPressed.charAt(index);
            } else if (releaseTimes[index] - releaseTimes[index - 1] == longestDuration) {
                slowestKey = (char) Math.max(slowestKey, keysPressed.charAt(index));
            }
        }
        return slowestKey;
    }
}
