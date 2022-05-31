// https://leetcode.com/problems/palindrome-partitioning
// T: O(n * 2^n)
// S: O(n * 2^n)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    private record Range(int start, int end) { }

    public static List<List<String>> partition(String s) {
        final List<List<String>> palindromicPartitions = new ArrayList<>();
        addValidPartitionsToResult(s, palindromicPartitions);
        return palindromicPartitions;
    }

    private static void addValidPartitionsToResult(String s, List<List<String>> result) {
        if (isPalindrome(s)) result.add(List.of(s));
        for (int i = 1 ; i < s.length() ; i++) {
           LinkedList<Range> segments = new LinkedList<>();
           segments.add(new Range(0, i));
           segments.add(new Range(i, s.length()));
           addValidPartitionsToResult(s, result, segments);
        }
    }

    private static void addValidPartitionsToResult(String s, List<List<String>> result, LinkedList<Range> segments) {
        if (!isPalindrome(s, getSecondLast(segments))) return;
        final Range lastSegment = lastSegment(segments);
        if (isPalindrome(s, lastSegment)) {
            result.add(getPartitions(s, segments));
        }
        if (lastSegment.start + 1 < s.length()) {
            segments.pollLast();
        }
        for (int i = lastSegment.start + 1 ; i < s.length() ; i++) {
            segments.addLast(new Range(lastSegment.start, i));
            segments.addLast(new Range(i, lastSegment.end));
            addValidPartitionsToResult(s, result, segments);
            segments.pollLast();
            segments.pollLast();
        }
        if (lastSegment.start + 1 < s.length()) {
            segments.add(lastSegment);
        }
    }

    private static List<String> getPartitions(String s, List<Range> segments) {
        final List<String> result = new LinkedList<>();
        for (Range range : segments) {
            result.add(s.substring(range.start, range.end));
        }
        return result;
    }

    private static Range getSecondLast(List<Range> segments) {
        return segments.get(segments.size() - 2);
    }

    private static Range lastSegment(List<Range> segments) {
        return segments.get(segments.size() - 1);
    }

    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length());
    }

    private static boolean isPalindrome(String s, Range range) {
        return isPalindrome(s, range.start, range.end);
    }

    public static boolean isPalindrome(String s, int start, int end) {
        for (int i = start ; i < start + (end - start) / 2 ; i++) {
            if (s.charAt(i) != s.charAt(end - i + start - 1)) return false;
        }
        return true;
    }
}
