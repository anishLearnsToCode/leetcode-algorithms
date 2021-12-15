public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int power = 1;
        char current = s.charAt(0);
        for (int index = 1, frequency = 1 ; index < s.length() ; index++) {
            if (s.charAt(index) == current) frequency++;
            else {
                current = s.charAt(index);
                frequency = 1;
            }
            power = Math.max(power, frequency);
        }
        return power;
    }
}
