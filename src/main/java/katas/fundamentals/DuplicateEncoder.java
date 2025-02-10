package katas.fundamentals;

import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateEncoder {
    public static String encode(String word){

        Map<Character, Long> frequency = word.toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));


        return word.toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .map(c -> frequency.get(c) > 1 ? ")" : "(")
                .collect(Collectors.joining());

//        StringBuilder sb = new StringBuilder();
//        for (String s : word.toLowerCase().split("")) {
//            String letter = frequency.get(s) > 1 ? ")" : "(";
//            sb.append(letter);
//        }
//        return sb.toString();

    }

}
/*
public class DuplicateEncoder {
	static String encode(String word){
        return word.toLowerCase()
                   .chars()
                   .mapToObj(i -> String.valueOf((char)i))
                   .map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
                   .collect(Collectors.joining());
  }
}
 */
