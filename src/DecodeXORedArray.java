public class DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        final int[] result = new int[encoded.length + 1];
        result[0] = first;
        int next = first, i = 1;
        for (int element : encoded) {
            next = element ^ next;
            result[i++] = next;
        }
        return result;
    }
}
