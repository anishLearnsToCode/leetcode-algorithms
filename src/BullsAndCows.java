public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] count = new int[10];
        for (int index =0 ; index < secret.length() ; index++) {
            if (secret.charAt(index) == guess.charAt(index)) {
                bulls++;
            } else {
                if (count[secret.charAt(index) - '0']++ < 0) cows++;
                if (count[guess.charAt(index) - '0']-- > 0) cows++;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
