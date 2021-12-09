public class HowManyNumbersAreSmallerThanCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        final int[] elementsFrequency = getElementsFrequency(nums);
        final int[] elementsSmallerThan = countSmallerThan(elementsFrequency);
        final int[] result = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
            result[i] = elementsSmallerThan[nums[i]];
        }
        return result;
    }

    private int[] getElementsFrequency(int[] array) {
        final int[] frequency = new int[101];
        for (int element : array) {
            frequency[element]++;
        }
        return frequency;
    }

    private int[] countSmallerThan(int[] frequency) {
        final int[] smallerThan = new int[101];
        for (int i = 1 ; i < 101 ; i++) {
            smallerThan[i] = smallerThan[i - 1] + frequency[i - 1];
        }
        return smallerThan;
    }
}
