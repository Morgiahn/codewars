package katas.kyu6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

/*

Given a string of words, you need to find the highest scoring word.

Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.

For example, the score of abad is 8 (1 + 2 + 1 + 4).

You need to return the highest scoring word as a string.

If two words score the same, return the word that appears earliest in the original string.

All letters will be lowercase and all inputs will be valid.


 */
public class HighestScoringWord {
    public static String high(String s) {
        // Your code here...
        var r  = Arrays.stream(s.split("\\s+"))
                .sorted(Comparator.comparing(w -> -wordValue(w)))
                .findFirst();
        return r.get();
    }

    static int wordValue(String s) {
        return s.chars().mapToObj(i -> i - 96).reduce( 0, (x, y ) -> x = x+ y);
    }
}

//                .orElse("0");
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));