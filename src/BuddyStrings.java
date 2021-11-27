import java.util.Arrays;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        final int[] characterFrequencies = new int[26];
        final int[] need = new int[26];
        int differences = 0;
        char c;
        for (int index = 0 ; index < s.length() ; index++) {
            c = s.charAt(index);
            characterFrequencies[c - 'a']++;
            if (c != goal.charAt(index)) {
                differences++;
                need[goal.charAt(index) - 'a']++;
                need[c - 'a']--;
            }
        }
        if (differences == 1 || differences > 2) return false;
        if (differences == 0 && oneCharOccurrsMoreThanOnce(characterFrequencies)) return true;
        return differences == 2 && Arrays.stream(need).allMatch(val -> val == 0);
    }

    private boolean oneCharOccurrsMoreThanOnce(int[] frequencies) {
        for (int frequency : frequencies) {
            if (frequency > 1) return true;
        }
        return false;
    }
}
