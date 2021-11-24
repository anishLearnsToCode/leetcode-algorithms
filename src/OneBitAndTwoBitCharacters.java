public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        for (int index = 0 ; index < bits.length ; index++) {
            if (bits[index] == 1) {
                index++;
            } else if (bits[index] == 0 && index == bits.length - 1) {
                return true;
            }
        }
        return false;
    }
}
