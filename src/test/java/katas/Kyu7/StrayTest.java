package katas.Kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrayTest {

    @Test
    public void threeElements1() {
        assertEquals(2, getActualFor(2, 1, 1));
    }

    @Test
    public void threeElements2() {
        assertEquals(2, getActualFor(1, 2, 1));
    }

    @Test
    public void threeElements3() {
        assertEquals(2, getActualFor(1, 1, 2));
    }

    private int getActualFor(int... numbers) {
        return Stray.stray(numbers);
    }
}
