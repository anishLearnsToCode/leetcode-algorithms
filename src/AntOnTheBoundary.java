// https://leetcode.com/problems/ant-on-the-boundary
// T: O(N)
// S: O(1)

public class AntOnTheBoundary {
    public int returnToBoundaryCount(int[] array) {
        int onTheBoundary = 0, distance = 0;
        for (int element : array) {
            distance += element;
            if (distance == 0) {
                onTheBoundary++;
            }
        }
        return onTheBoundary;
    }
}
