// https://leetcode.com/problems/find-the-peaks
// T: O(n)
// S: O(1)

import java.util.ArrayList;
import java.util.List;

public class FindThePeaks {
    public List<Integer> findPeaks(int[] mountain) {
        final List<Integer> peaks = new ArrayList<>();

        for (int i = 1 ; i < mountain.length - 1 ; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                peaks.add(i);
            }
        }

        return peaks;
    }
}
