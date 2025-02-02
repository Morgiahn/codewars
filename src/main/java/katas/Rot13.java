package katas;


/*
How can you tell an extrovert from an introvert at NSA?
Va gur ryringbef, gur rkgebireg ybbxf ng gur BGURE thl'f fubrf.

I found this joke on USENET, but the punchline is scrambled. Maybe you can decipher it?
According to Wikipedia, ROT13 is frequently used to obfuscate jokes on USENET.

For this task you're only supposed to substitute characters. Not spaces, punctuation, numbers, etc.

Test examples:

"EBG13 rknzcyr." -> "ROT13 example."

"This is my first ROT13 excercise!" -> "Guvf vf zl svefg EBG13 rkprepvfr!"


 */
public class Rot13 {
    private static int ASCII_Z = 90;
    private static int ASCII_A = 65;
    private static int ASCII_a = 97;
    private static int ASCII_z = 122;
    private static int OFFSET_CASE = 32;
    private static int ROT = 13;

    public static String rot13(String message) {
        return message.chars()
                .map(i -> i <= ASCII_Z && i >= ASCII_A ?  rotateLowerCodeAscii(i + OFFSET_CASE) - OFFSET_CASE : i)
                .map(i -> i >= ASCII_a && i <= ASCII_z ? rotateLowerCodeAscii(i) : i)
                .collect(StringBuffer::new,
                            StringBuffer::appendCodePoint,
                            (sb1, sb2) -> sb1.append(sb2))
                .toString( );
    }


    private static int rotateLowerCodeAscii(int codeAscii) {
        codeAscii += ROT;
        if (codeAscii > ASCII_z) {
            codeAscii -= 2 * ROT;
        }
        return codeAscii;
    }
}

/* solutions

  static String rot13(String message) {
    return message.chars().mapToObj(c -> "" + (char) c)
        .map(c -> "" + (char) (c.charAt(0) + (c.matches("(?i)[A-M]") ? 13 : c.matches("(?i)[N-Z]") ? -13 : 0)))
        .collect(joining());
  }

static String rot13(String message) {
    var in = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    var out = "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm";
    var encoded = new StringBuilder();
    for (char c : message.toCharArray()) {
      int i = in.indexOf(c);
      if (i >= 0) {
        c = out.charAt(i);
      }
      encoded.append(c);
    }
    return encoded.toString();
  }



  private static final Map<String, String> CHAR_MAPPING = new HashMap<>();

    static {
        IntStream.rangeClosed('A', 'M').forEach(key -> CHAR_MAPPING.put(String.valueOf((char) key), String.valueOf((char) (key + 13))));
        IntStream.rangeClosed('N', 'Z').forEach(key -> CHAR_MAPPING.put(String.valueOf((char) key), String.valueOf((char) (key - 13))));
        IntStream.rangeClosed('a', 'm').forEach(key -> CHAR_MAPPING.put(String.valueOf((char) key), String.valueOf((char) (key + 13))));
        IntStream.rangeClosed('n', 'z').forEach(key -> CHAR_MAPPING.put(String.valueOf((char) key), String.valueOf((char) (key - 13))));
    }

   public static String rot13(String message) {
      return Arrays.stream(message.split("")).map(key -> CHAR_MAPPING.getOrDefault(key, key)).collect(Collectors.joining());

   }

 */