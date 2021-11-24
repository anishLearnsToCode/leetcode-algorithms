public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (letters[middle] <= target) left = middle + 1;
            else right = middle - 1;
        }
        return letters[left % letters.length];
    }
}
