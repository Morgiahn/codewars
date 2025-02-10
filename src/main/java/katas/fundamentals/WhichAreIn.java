package katas.fundamentals;

import java.util.*;
import java.util.stream.Collectors;

public class WhichAreIn {
    /**
     * Returns a sorted array of strings containing the strings in array1 that are substrings
     * of those in array2.
     *
     * Requires that none of the strings contain the special '\0' character.
     *
     * This implementation takes O(n*m + n logn) time, where n is array1.size() and m is the count of all
     * characters in the strings of array2.
     *   Join array2 in O(m).
     *   For each of n strings in array1, search the joined string of length m. O(n*m).
     *   Sort the (up to) n strings in result. O(n logn).
     *
     * The solution can be improved by using a data structure such as a trie to determine if strings in
     * array1 are a substring of any string in array2.
     *
     */

    public static String[] inArray(String[] array1, String[] array2) {
//        LinkedHashSet<String> list = new LinkedHashSet<>();
//        for(String s : array1) {
//            for(String s2: array2) {
//                if (s2.indexOf(s) != -1 ) {
//                    list.add(s);
//                }
//            }
//        }
//        show(array1);
//        show(array2);
//        System.out.println("--show list :");
        List<String> list = Arrays.stream(array1)
                .filter(e1 -> Arrays.stream(array2)
                        .anyMatch(e2 -> e2.indexOf(e1) != -1  ))
//                .peek( e -> System.out.println("- " + e))
                .collect(Collectors.toList());

        String[] result = list.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }

    static void show(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for(String s: arr) {
            sb.append("\"")
                    .append(s)
                    .append("\"")
                    .append(",");
        }
        System.out.println(sb);
    }
}

/*
public class WhichAreIn {

	public static String[] inArray(String[] array1, String[] array2) {
    return Arrays.stream(array1)
      .filter(str ->
        Arrays.stream(array2).anyMatch(s -> s.contains(str)))
      .distinct()
      .sorted()
      .toArray(String[]::new);
	}
}
*/
