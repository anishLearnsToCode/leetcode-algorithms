import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class NumberOfDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        final String[] dateParts1 = date1.split("-");
        final String[] dateParts2 = date2.split("-");
        final LocalDate d1 = LocalDate.of(
                Integer.parseInt(dateParts1[0]),
                Integer.parseInt(dateParts1[1]),
                Integer.parseInt(dateParts1[2])
        );
        final LocalDate d2 = LocalDate.of(
                Integer.parseInt(dateParts2[0]),
                Integer.parseInt(dateParts2[1]),
                Integer.parseInt(dateParts2[2])
        );
        return (int) Math.abs(DAYS.between(d1, d2));
    }
}
