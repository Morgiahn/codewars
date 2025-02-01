package katas;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {
    public String spinWords0(String sentence) {
        //TODO: Code stuff here
        String[] words = sentence.split(" ");
        String result = "";
        for(String w: words) {
            result += reverse0(w) + " ";
        }
        return result.trim();
    }

    private static String reverse0(String e) {
        if (e.length() > 4) {
            StringBuilder sb = new StringBuilder(e);
            sb.reverse();
            return sb.toString();
        }
        return e;
    }

    public String spinWords(String sentence) {
        //TODO: Code stuff here
        return Arrays.stream(sentence.split(" "))
                .map(SpinWords::reverse)
                .collect(Collectors.joining(" "));
    }

    private static String reverse(String e) {
        return e.length() > 4 ? new StringBuilder(e).reverse().toString(): e;
    }

}
