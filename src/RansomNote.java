import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomNoteCharfrequencies = getFrequencies(ransomNote);
        Map<Character, Integer> magazineCharfrequencies = getFrequencies(magazine);
        for (Character letter : ransomNoteCharfrequencies.keySet()) {
            if (ransomNoteCharfrequencies.get(letter) > magazineCharfrequencies.getOrDefault(letter, 0)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getFrequencies(String string) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }
        return frequencies;
    }
}
