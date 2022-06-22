// https://leetcode.com/problems/repeated-dna-sequences
// T: O(N)
// S: O(N)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {
    private static final Map<Character, Integer> NUCLEOTIDES_TO_INT = Map.ofEntries(
        Map.entry('A', 0),
        Map.entry('C', 1),
        Map.entry('G', 2),
        Map.entry('T', 3)
    );

    public List<String> findRepeatedDnaSequences(String s) {
        final List<String> dnaSequences = new ArrayList<>();
        final Set<Integer> encodings = new HashSet<>();
        final Set<Integer> repeatedEncodings = new HashSet<>();

        for (int i = 0 ; i < s.length() - 9 ; i++) {
            final int encoding = getSequenceEncoding(s, i);
            if (!encodings.add(encoding) && repeatedEncodings.add(encoding)) {
                dnaSequences.add(s.substring(i, i + 10));
            }
        }

        return dnaSequences;
    }

    private int getSequenceEncoding(String s, int index) {
        int encoding = 0;
        for (int i = index ; i < index + 10 ; i++) {
            encoding <<= 2;
            encoding |= NUCLEOTIDES_TO_INT.get(s.charAt(i));
        }
        return encoding;
    }
}
