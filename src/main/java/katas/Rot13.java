package katas;

import java.util.Collections;
import java.util.stream.Collectors;

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
    public static String rot13(String message) {
        return message.chars()
                .map(Rot13::rotateCodeAscii)
                .collect(StringBuffer::new,
                            StringBuffer::appendCodePoint,
                            (sb1, sb2) -> sb1.append(sb2))
                .toString();
    }


    private static int rotateCodeAscii(int codeAscii) {
        if (codeAscii < 91 && codeAscii >  64) {
            return  rotateCodeAscii(codeAscii + 32) - 32;
        }
        else if (codeAscii > 96 && codeAscii < 123) {
            codeAscii += 13;
            if (codeAscii >= 122) {
                codeAscii -= 2 * 13;
            }
        }
        return codeAscii;
    }
}
