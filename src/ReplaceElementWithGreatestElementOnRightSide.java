public class ReplaceElementWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] array) {
        int[] result = new int[array.length];
        result[result.length - 1] = -1;
        for (int index = array.length - 2, max = array[array.length - 1]; index >= 0 ; index--) {
            result[index] = max;
            max = Math.max(max, array[index]);
        }
        return result;
    }
}
