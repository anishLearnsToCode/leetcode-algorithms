// https://leetcode.com/problems/number-of-senior-citizens
// T: O(N)
// S: O(1)

public class NumberOfSeniorCitizens {
    public int countSeniors(String[] details) {
        int seniors = 0;
        for (String detail : details) {
            int age = getAge(detail);
            if (age > 60) seniors++;
        }
        return seniors;
    }

    private int getAge(String detail) {
        return Integer.parseInt(detail.substring(11, 13));
    }
}
