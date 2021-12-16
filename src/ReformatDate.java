public class ReformatDate {
    public String reformatDate(String date) {
        final String[] parts = date.split(" ");
        return new StringBuilder(parts[2])
                .append('-')
                .append(getMonth(parts[1]))
                .append('-')
                .append(getDay(parts[0]))
                .toString();
    }

    private String getMonth(String month) {
        return switch (month) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> "";
        };
    }

    private String getDay(String string) {
        if (string.length() == 3) {
            return '0' + string.substring(0, 1);
        } return string.substring(0, 2);
    }
}
