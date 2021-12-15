public class NumberOfStudentsDoingHomeworkAtGivenTime {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int students = 0;
        for (int index = 0 ; index < startTime.length ; index++) {
            if (startTime[index] <= queryTime && queryTime <= endTime[index]) {
                students++;
            }
        }
        return students;
    }
}
