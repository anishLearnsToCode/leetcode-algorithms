public class MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] array) {
        int lowestPoint =getLowestPoint(array);
        return 1 - Math.min(0, lowestPoint);
    }

    private int getLowestPoint(int[] array) {
        int lowestPoint = 0, sum = 0;
        for (int element : array) {
            sum += element;
            if (sum < lowestPoint) lowestPoint = sum;
        }
        return lowestPoint;
    }
}
