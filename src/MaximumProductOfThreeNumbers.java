public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] numbers) {
        int positive1 = Integer.MIN_VALUE, positive2 = Integer.MIN_VALUE, positive3 = Integer.MIN_VALUE,
                negative1 = Integer.MAX_VALUE,
                negative2 = Integer.MAX_VALUE;

        for (int number : numbers) {
            if (number > positive1) {
                positive3 = positive2;
                positive2 = positive1;
                positive1= number;
            } else if (number > positive2) {
                positive3 = positive2;
                positive2 = number;
            } else if (number> positive3) {
                positive3 = number;
            }
            if (number < negative2) {
                negative1 = negative2;
                negative2 = number;
            } else if (number < negative1) {
                negative1 = number;
            }
        }

        return Math.max(positive1 * positive2 * positive3, negative1 * negative2 * positive1);
    }
}
