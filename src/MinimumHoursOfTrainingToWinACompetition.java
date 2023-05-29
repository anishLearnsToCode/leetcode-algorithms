// https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition
// T: O(N)
// S: O(1)

public class MinimumHoursOfTrainingToWinACompetition {
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int trainingRequired = 0;

        for (int index = 0 ; index < energy.length ; index++) {
            if (energy[index] >= initialEnergy) {
                trainingRequired += energy[index] - initialEnergy + 1;
                initialEnergy += energy[index] - initialEnergy + 1;
            }
            if (experience[index] >= initialExperience) {
                trainingRequired += experience[index] - initialExperience + 1;
                initialExperience += experience[index] - initialExperience + 1;
            }
            initialEnergy -= energy[index];
            initialExperience += experience[index];
        }

        return trainingRequired;
    }
}
