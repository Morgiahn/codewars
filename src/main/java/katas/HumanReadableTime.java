package katas;

import java.time.LocalDateTime;
import static java.time.ZoneOffset.UTC;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        // Do something
        LocalDateTime time = LocalDateTime.ofEpochSecond(seconds, 0, UTC);
        return hour(time) + ":" + digit(time.getMinute()) + ":" + digit(time.getSecond());
    }
    static String hour(LocalDateTime time) {
        int days = time.getDayOfMonth() - 1;
        int h = time.getHour() + 24 * days;
        return digit(h);
    }

    static String digit(int timeValue) {
        return timeValue < 10 ? "0" + String.valueOf(timeValue) : String.valueOf(timeValue);
    }
}


//public class HumanReadableTime {
//    public static String makeReadable(int seconds) {
//        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
//    }
//}
