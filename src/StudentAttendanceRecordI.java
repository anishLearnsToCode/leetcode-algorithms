public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int consecutiveLate = 0, absentees = 0;
        for (int index = 0 ; index < s.length() ; index++) {
            if (s.charAt(index) == 'L') {
                consecutiveLate++;
            } else {
                if (s.charAt(index) == 'A') absentees++;
                consecutiveLate = 0;
            }
            if (absentees >= 2 || consecutiveLate >= 3) {
                return false;
            }
        }
        return true;
    }
}
