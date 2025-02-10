package katas.fundamentals.rgbtohex;

import katas.fundamentals.rgbtohex.RgbToHex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RgbToHexTest {

    @Test
    void rgb() {
        assertEquals("000000", RgbToHex.rgb(0, 0, 0));
        assertEquals("010203", RgbToHex.rgb(1, 2, 3));
        assertEquals("FFFFFF", RgbToHex.rgb(255, 255, 255));
        assertEquals("FEFDFC", RgbToHex.rgb(254, 253, 252));
        assertEquals("00FF7D", RgbToHex.rgb(-20, 275, 125));
    }
}
