/*
    Problem Number : 27
    Problem Link: https://leetcode.com/problems/remove-element/
 */

public class RemoveElement {
    public int removeElement(int[] array, int val) {
        int position = 0;
        for (int element : array) {
            if (element == val) {
                continue;
            }

            array[position++] = element;
        }

        return position;
    }
}
