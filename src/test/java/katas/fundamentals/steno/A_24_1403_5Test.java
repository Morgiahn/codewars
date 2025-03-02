package katas.fundamentals.steno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A_24_1403_5Test {

    @Test
    public void TEST1() {
        assertEquals("HELLO WORLD",A_24_1403_5.read(new byte[][]{new byte[]{1,1,0,0,0,0,0,0,0,0,1},new byte[]{0,0,1,1,1,0,0,1,1,1,0},new byte[]{0,0,0,0,0,1,1,0,0,0,0},new byte[]{0,0,0,0,0,0,0,0,0,0,0},new byte[]{0,0,0,0,0,1,0,0,0,0,0},new byte[]{0,0,1,1,0,0,0,0,0,1,0},new byte[]{0,0,0,0,0,0,0,0,0,0,1},new byte[]{0,1,0,0,0,0,0,0,0,0,0},new byte[]{0,0,0,0,1,0,1,1,0,0,0},new byte[]{0,0,0,0,0,0,0,0,0,0,0},new byte[]{1,0,0,0,0,1,0,0,0,0,0},new byte[]{0,0,0,0,0,0,0,0,1,0,0},}));
    }

    @Test
    public void TEST2() {
        assertEquals("A_24_1403_5",A_24_1403_5.read(new byte[][]{new byte[]{1,0,0,0,0,0,0,0,0,0,0},new byte[]{0,0,0,0,0,0,0,0,0,0,0},new byte[]{0,1,0,0,1,0,0,1,0,1,0},new byte[]{1,0,0,0,0,1,0,0,0,0,0},new byte[]{0,0,1,0,0,0,0,0,0,0,0},new byte[]{0,0,0,0,0,0,0,0,1,0,0},new byte[]{0,0,0,1,0,0,1,0,0,0,0},new byte[]{0,1,0,0,1,0,0,0,0,1,1},new byte[]{0,0,0,0,0,0,0,0,0,0,0},new byte[]{0,0,0,0,0,0,0,0,0,0,0},new byte[]{0,1,0,0,1,0,0,0,0,1,0},new byte[]{0,0,0,0,0,0,0,0,0,0,0},}));
    }
    @Test
    public void TEST3() {
        assertEquals("Stenography 4 Life".toUpperCase(),A_24_1403_5.read(new byte[][]{new byte[]{0,0,1,0,0,1,0,1,0,1,0,0,0,0,0,1,1,1},new byte[]{0,0,0,1,1,0,1,0,1,0,0,0,0,0,1,0,0,0},new byte[]{1,1,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0},new byte[]{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},new byte[]{1,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0},new byte[]{0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},new byte[]{0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},new byte[]{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},new byte[]{0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0},new byte[]{0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,0},new byte[]{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0},}));
    }
    @Test
    public void TEST4() {
        assertEquals("PRONTF(\"+|-!$*\")",A_24_1403_5.read(new byte[][]{new byte[]{0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0},new byte[]{1,1,1,1,0,0,0,0,0,0,1,1,1,1,0,1},new byte[]{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},new byte[]{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},new byte[]{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},new byte[]{0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1},new byte[]{0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0},new byte[]{1,0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},new byte[]{0,0,0,0,0,0,1,1,1,1,0,1,1,1,1,1},new byte[]{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},}));
    }

}
