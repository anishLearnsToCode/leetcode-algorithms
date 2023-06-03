// https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array
// T: O(N)
// S: O(1)

public class ShortestDistanceToTargetStringInACircularArray {
    public int closetTarget(String[] words, String target, int startIndex) {
        if (words[startIndex].equals(target)) return 0;

        for (int left =  (startIndex - 1 + words.length) % words.length, right = (startIndex + 1) % words.length, count = 1;
             count <= words.length / 2;
             left = (left - 1 + words.length) % words.length, right = (right + 1) % words.length, count++
        ) {
            if (words[left].equals(target) || words[right].equals(target)) return count;
        }
        return -1;
    }
}
