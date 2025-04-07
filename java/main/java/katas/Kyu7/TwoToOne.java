package katas.Kyu7;


/*
Take 2 strings s1 and s2 including only letters from a to z.
Return a new sorted string (alphabetical ascending), the longest possible,
containing distinct letters - each taken only once - coming from s1 or s2.
Examples:

a = "xyaabbbccccdefww"
b = "xxxxyyyyabklmopq"
longest(a, b) -> "abcdefklmopqwxy"

a = "abcdefghijklmnopqrstuvwxyz"
longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"



 */
public class TwoToOne {
    public static String longest (String s1, String s2) {
        // your code
        return (s1 + s2).chars()
                .distinct()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
//                .collect(StringBuilder::new, (sb, i) -> sb.append((char) i), StringBuilder::append).toString();
    }
}

/*
     public static String longest (String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        (s1 + s2).chars().distinct().sorted().forEach(c -> sb.append((char) c));
        return sb.toString();
    }

    public static String longest (String s1, String s2) {
        return Stream.of(s1.concat(s2).split(""))
                  .sorted()
                  .distinct()
                  .collect(Collectors.joining());
    }

 */
