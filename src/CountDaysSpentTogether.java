// https://leetcode.com/problems/count-days-spent-together
// T: O(1)
// S: O(1)

import java.time.LocalDate;

public class CountDaysSpentTogether {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob){
        final long aliceArrive = getEpochDay(arriveAlice);
        final long aliceLeave = getEpochDay(leaveAlice);
        final long bobArrive = getEpochDay(arriveBob);
        final long bobLeave = getEpochDay(leaveBob);

        //No intersection of days
        if(aliceLeave < bobArrive || bobLeave < aliceArrive) return 0;

        return (int) ((Math.min(aliceLeave, bobLeave) - Math.max(aliceArrive, bobArrive)) + 1);
    }

    private long getEpochDay(String mmDD) {
        return LocalDate.of(2021,Integer.parseInt(mmDD.substring(0,2)),Integer.parseInt(mmDD.substring(3,5))).toEpochDay();
    }
}
