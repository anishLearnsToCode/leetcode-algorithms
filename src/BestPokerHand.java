// https://leetcode.com/problems/best-poker-hand
// T: O(1)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

public class BestPokerHand {
    public String bestHand(int[] ranks, char[] suits) {
        if (sameSuit(suits)) {
            return "Flush";
        }

        final Map<Integer, Integer> frequencies = getFrequencies(ranks);
        final int maxFrequency = frequencies.values().stream().max(Integer::compare).get();

        if (maxFrequency >= 3) {
            return "Three of a Kind";
        }
        if (maxFrequency == 2) {
            return "Pair";
        }

        return "High Card";
    }

    private Map<Integer, Integer> getFrequencies(int[] ranks) {
        final Map<Integer, Integer> frequencies = new HashMap<>();
        for (int rank : ranks) {
            frequencies.put(rank, frequencies.getOrDefault(rank, 0) + 1);
        }
        return frequencies;
    }

    private boolean sameSuit(char[] suits) {
        char first = suits[0];
        for (char suit : suits) {
            if (suit != first) return false;
        }
        return true;
    }
}
