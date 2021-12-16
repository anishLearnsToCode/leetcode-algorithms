public class MaximumProductOfTwoElementsInArray {
    public int maxProduct(int[] array) {
        int max = array[0], secondMax = Integer.MIN_VALUE;
        for (int index = 1 ; index < array.length ; index++) {
            if (array[index] > max) {
                secondMax = max;
                max = array[index];
            } else if (array[index] > secondMax) {
                secondMax = array[index];
            }
        }
        return (max - 1) * (secondMax - 1) ;
    }
}
