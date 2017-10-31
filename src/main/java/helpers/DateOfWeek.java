package helpers;

import java.util.Calendar;

public class DateOfWeek {

    public static String getCurrentDayOfWeek() {
        Calendar c = Calendar.getInstance();
        String dayOfWeek = getDayOfWeek(c.get(Calendar.DAY_OF_WEEK));
        return dayOfWeek;
    }

    private static String getDayOfWeek(int value) {
        String day = "";
        switch (value) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
        }
        return day;

    }
}
