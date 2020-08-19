public class StringCompression {
    public int compress(char[] array) {
        if (array.length == 0) return 0;

        StringBuilder accumulator = new StringBuilder();
        char current = array[0];
        int count = 1;
        for (int index = 1 ; index < array.length ; index++) {
            if (array[index] == current) {
                count++;
            } else {
                accumulator.append(current).append(count > 1 ? count : "");
                current = array[index];
                count = 1;
            }
        }
        accumulator.append(current).append(count > 1 ? count : "");
        copyInto(array, accumulator);
        return accumulator.length();
    }

    private void copyInto(char[] array, StringBuilder buffer) {
        for (int index = 0 ; index < buffer.length() ; index++) {
            array[index] = buffer.charAt(index);
        }
    }
}
