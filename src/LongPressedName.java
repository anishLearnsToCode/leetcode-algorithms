public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        char current = name.charAt(0);
        for (int i = 0, j = 0, freq = 0, typedFreq = 0 ; i < name.length() && j < typed.length() ; ) {
            while (i < name.length() && name.charAt(i) == current) {
                i++;
                freq++;
            }
            while (j < typed.length() && typed.charAt(j) == current) {
                j++;
                typedFreq++;
            }
            if (typedFreq < freq) return false;
            if (i == name.length() && j < typed.length()) return false;
            if (j == typed.length() && i < name.length()) return false;
            current = i >= name.length() ? ' ' : name.charAt(i);
            freq = typedFreq = 0;
        }
        return true;
    }
}
