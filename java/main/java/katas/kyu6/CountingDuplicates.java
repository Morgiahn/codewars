package katas.kyu6;

import java.util.Map;
import java.util.stream.Collectors;

/*

Count the number of Duplicates

Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string.
The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
Example

"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
Strings
Fundamentals


 */
public class CountingDuplicates {
    public static int duplicateCount(String text) {
        // Write your code here
        Map<String, Long> frq = text.toLowerCase().chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

        // filter count==1
        Map<String, Long> frq2 = frq.entrySet().stream().filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return frq2.size();
    }

}


/*
import java.util.stream.Collectors;

public class CountingDuplicates {
  public static int duplicateCount(String text) {
    return (int)text.toLowerCase().chars().boxed().collect(Collectors.groupingBy(k->k,Collectors.counting())).values().stream().filter(e->e>1).count();
  }
}
 */
