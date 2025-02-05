package katas.string.incrementer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringIncrementer {
    public static String incrementString(String str) {
        String number = splitNumbers(str);
        String prefix = str.substring(0, str.length() - number.length() );
        String numPart = incrementNumber(number);
        return prefix + numPart;
    }

    static String splitNumbers(String str) {
        String regexfindLastNumbers = "([\\D]*)(\\d+)$";
        Pattern pattern = Pattern.compile(regexfindLastNumbers);
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ?  matcher.group(2) : "";
    }

    public static String incrementNumber(String number) {
        if (number.length() < 1) {
            return "1";
        }
        int len = number.length();
        String prefix = number.substring(0, len -1);
        String slast = number.substring( len-1 , len);

        int ilast = Integer.parseInt(slast);
        ilast++;
        if (ilast > 9) {
            return incrementNumber(prefix) + "0";
        }
        return prefix + String.valueOf(ilast);
    }
}
