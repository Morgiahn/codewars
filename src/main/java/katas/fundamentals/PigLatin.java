package katas.fundamentals;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PigLatin {
    public static String pigIt(String str) {
        // Write code here
        return Arrays.stream(str.split(" "))
                .map(PigLatin::moveFirstLetter)
                .map(PigLatin::addAy)
                .collect(Collectors.joining(" "));
    }


    private static String moveFirstLetter(String e) {
        return e.substring(1, e.length()) + e.charAt(0);
    }

    private static String addAy(String e) {
        return Character.isLetter(e.charAt(0)) ? e + "ay" : e;
    }


}
