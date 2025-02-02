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
        System.out.println("in " + codeAscii);
        codeAscii += ROT;
        if (codeAscii > ASCII_z) {
            codeAscii -= 2 * ROT;
        }
        System.out.println("out: " + codeAscii);
        return codeAscii;
    }
}
