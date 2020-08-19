public class NumberOfSegmentsInString {
    public int countSegments(String string) {
        boolean encounteredSpace = true;
        int segments = 0;
        for (int index = 0 ; index < string.length() ; index++) {
            if (encounteredSpace && string.charAt(index) != ' ') {
                encounteredSpace = false;
                segments++;
            } else if (!encounteredSpace && string.charAt(index) == ' ') {
                encounteredSpace = true;
            }
        }
        return segments;
    }
}
