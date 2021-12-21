public class LatestTimeByReplacingHiddenDigits {
    public String maximumTime(String time) {
        String[] parts = time.split(":");
        String hour = parts[0], minutes = parts[1];
        return new StringBuilder(maxHours(hour)).append(':').append(maxMinutes(minutes)).toString();
    }

    private String maxHours(String string) {
        if (string.charAt(0) == '?') {
            if (string.charAt(1) == '?') return "23";
            if (string.charAt(1) > '3') return "1" + string.charAt(1);
            return "2" + string.charAt(1);
        } else if (string.charAt(1) == '?') {
            return string.charAt(0) + (string.charAt(0) == '2' ? "3" : "9");
        }
        return string;
    }

    private String maxMinutes(String string) {
        if (string.charAt(0) == '?') {
            if (string.charAt(1) == '?') return "59";
            return "5" + string.charAt(1);
        } else if (string.charAt(1) == '?') {
            return string.charAt(0) + "9";
        }
        return string;
    }
}
