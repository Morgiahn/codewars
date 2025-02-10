package katas.fundamentals.rgbtohex;

public class RgbToHex {
    public static String rgb(int r, int g, int b) {
        return intToHex(r) + intToHex(g) + intToHex(b);
    }


    public static String intToHex(int value) {
        if (value < 0) {
            value = 0;
        }
        if (value > 255) {
            value = 255;
        }
        int first = value / 16;
        int second = value % 16;
        return String.format("%s%s", Integer.toHexString(first), Integer.toHexString(second)).toUpperCase();
    }

    public static String intToHexOneDigit(int value) {
        value <<= 4;
        return String.format("%s", Integer.toHexString(value)).toUpperCase();
    }
}

/**
 *     public static String rgb(int r, int g, int b) {
 *         return String.format("%02X%02X%02X", verify(r), verify(g), verify(b));
 *     }
 *
 *     private static int verify(int i) {
 *         return i > 0 ? Math.min(255, i) : 0;
 *     }
 */
