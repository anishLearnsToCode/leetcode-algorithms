public class DayOfTheYear {
    private static final int[] DAYS_UPTO_MONTH_IN_STD_YEAR = {
            0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365
    };

    private static final int[] DAYS_UPTO_MONTH_IN_LEAP_YEAR = {
            0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366
    };

    public int dayOfYear(String date) {
        String[] dateParts = date.split("-");
        final int year = Integer.parseInt(dateParts[0]);
        final int month = Integer.parseInt(dateParts[1]);
        final int day = Integer.parseInt(dateParts[2]);
        if (isLeapYear(year)) {
            return DAYS_UPTO_MONTH_IN_LEAP_YEAR[month - 1] + day;
        }
        return DAYS_UPTO_MONTH_IN_STD_YEAR[month - 1] + day;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }
}
