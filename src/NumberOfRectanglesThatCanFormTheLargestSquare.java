public class NumberOfRectanglesThatCanFormTheLargestSquare {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLength = 0, frequency = 0, length;
        for (int[] rectangle : rectangles) {
            length = Math.min(rectangle[0], rectangle[1]);
            if (length > maxLength) {
                maxLength = length;
                frequency = 1;
            } else if (length == maxLength) {
                frequency++;
            }
        }
        return frequency;
    }
}
