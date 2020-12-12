public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] array) {
        int maxOnes = 0, current = 0;
        for (int number : array) {
            if (number == 1) {
                current++;
                maxOnes = Math.max(maxOnes, current);
            } else {
                current = 0;
            }
        }

        return maxOnes;
    }

    public static void main(String[] args) {

    }
}
