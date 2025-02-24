package katas.fundamentals.kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.

Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.
Examples

"is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
"4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
""  -->  ""



 */
public class Order {

    record Tuple(int rank, String word) {
    }

    public static String order(String words) {
        if (words.isEmpty()) {
            return "";
        }

        return Arrays.stream(words.split(" "))
                .map(s -> new Tuple(
                        Integer.parseInt(s.replaceAll("[^0-9]", ""))
                        , s)
                )
                .sorted((a, b) -> a.rank - b.rank)
                .map(t -> t.word)
                .collect(Collectors.joining(" "));
    }
}
/*
import java.util.Arrays;
import java.util.Comparator;

public class Order {
  public static String order(String words) {
    return Arrays.stream(words.split(" "))
      .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
      .reduce((a, b) -> a + " " + b).get();
  }
}

// with regex

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
public class Order {
  public static String order(String words) {
    return Pattern.compile("\\s").splitAsStream(words).sorted((a, b) -> {
      Matcher am = Pattern.compile("\\d").matcher(a), bm = Pattern.compile("\\d").matcher(b);
      am.find(); bm.find();
      return Integer.parseInt(am.group(0)) - Integer.parseInt(bm.group(0));
    }).collect(Collectors.joining(" "));
  }
}

 */

/*
        if (words.isEmpty()) { return ""; }
        String[] mots = words.split(" ");
        List<Tuple> tuples = new ArrayList<Tuple>();
        for(String s: mots) {
            tuples.add(new Tuple(Integer.parseInt(s.replaceAll("[^0-9]", "")), s));
        }
        tuples.sort((a, b) -> a.x - b.x);
        String result ="";
        for(Tuple t: tuples) {
            result += t.y + " ";
        }

        return result.trim();

    }

    public static record Tuple(int x, String y) { }
 */
