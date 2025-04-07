package katas.Kyu7;

import katas.Kyu7.HighestAndLowest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighestAndLowestTest {

    @Test
    public void test1() {
        assertEquals("42 -9", HighestAndLowest.highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }
    @Test
    public void test2() {
        assertEquals("3 1", HighestAndLowest.highAndLow("1 2 3"));
    }

}
