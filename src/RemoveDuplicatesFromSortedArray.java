public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int position = 1;
        for (int index = 1, previouslyEncountered = array[0]; index < array.length ; index++) {
            if (array[index] != previouslyEncountered) {
                array[position++] = array[index];
                previouslyEncountered = array[index];
            }
        }

        return position;
    }
}
