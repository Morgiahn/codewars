package katas;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {
    public String spinWords0(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String w: words) {
            sb.append(reverse0(w)).append(" ");
        }
        return sb.toString().trim();
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
        return Arrays.stream(sentence.split(" "))
                .map(SpinWords::reverse)
                .collect(Collectors.joining(" "));
    }

    private static String reverse(String e) {
        return e.length() > 4 ? new StringBuilder(e).reverse().toString(): e;
    }

}
