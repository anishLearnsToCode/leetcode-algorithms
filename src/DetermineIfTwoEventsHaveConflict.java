// https://leetcode.com/problems/determine-if-two-events-have-conflict
// T: O(1)
// S: O(1)

public class DetermineIfTwoEventsHaveConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        final int[] event1EpochMinutes = getEpochMinutes(event1);
        final int[] event2EpochMinutes = getEpochMinutes(event2);
        return isIntersecting(event1EpochMinutes, event2EpochMinutes);
    }

    private boolean isIntersecting(int[] event1, int[] event2) {
        return Math.min(event1[1], event2[1]) >= Math.max(event1[0], event2[0]);
    }

    private int[] getEpochMinutes(String[] event) {
        return new int[] { getEpochMinutes(event[0]), getEpochMinutes(event[1])};
    }

    private int getEpochMinutes(String event) {
        final String hh = event.substring(0, 2), mm = event.substring(3);
        return toInt(hh) * 60 + toInt(mm);
    }

    private int toInt(String string) {
        int result = 0;
        for (int index = 0 ; index < string.length() ; index++) {
            result = 10 * result + (string.charAt(index) - '0');
        }
        return result;
    }
}
