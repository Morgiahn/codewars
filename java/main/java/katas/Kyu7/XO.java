package katas.Kyu7;

import java.util.Map;
import java.util.stream.Collectors;

/*
Check to see if a string has the same amount of 'x's and 'o's.
The method must return a boolean and be case insensitive.
The string can contain any char.

Examples input/output:

XO("ooxx") => true
XO("xooxx") => false
XO("ooxXm") => true
XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
XO("zzoo") => false

 */
public class XO {

    public static boolean getXO (String str) {

        Map<Character, Long> frequencies =  str.replaceAll("[^xoXO]", "")
                .chars().mapToObj(c -> (char) c)
                .map(Character::toLowerCase)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));

        return frequencies.getOrDefault('x', 0L).equals(frequencies.getOrDefault('o', 0L));

    }

}

/*
  public static boolean getXO (String str) {
    str = str.toLowerCase();
    return str.replace("o","").length() == str.replace("x","").length();

  }

  public static boolean getXO(String str) {
		int x = 0, o = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.toUpperCase().charAt(i) == 'O') o++;
			if(str.toUpperCase().charAt(i) == 'X') x++;
		}
		return x == o;
	}


  public static boolean getXO (String str) {
        Map<String, Long> count = str.toLowerCase().codePoints().mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Objects.equals(count.get("o"), count.get("x"));
    }
    
 */
