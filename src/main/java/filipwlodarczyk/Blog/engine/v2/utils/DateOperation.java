package filipwlodarczyk.Blog.engine.v2.utils;

import java.util.Calendar;
import java.util.Date;

public class DateOperation {

    public static Date getDate(int year, int month, int date) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, date); // Assumes MM/dd/yyyy
        return cal.getTime();
    }
}
