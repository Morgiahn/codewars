package katas.kyu8;

import katas.kyu8.SmallestIntegerFinder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SmallestIntegerFinderTest {
    @Test
    void sampleTests() {
        doTest(new int[]{78,56,-2,12,-8}, -8);
        doTest(new int[]{Integer.MIN_VALUE, -666}, Integer.MIN_VALUE);
        doTest(new int[]{666, Integer.MIN_VALUE}, Integer.MIN_VALUE);
        doTest(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, Integer.MAX_VALUE);
        doTest(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE}, Integer.MIN_VALUE);
    }

    private static void doTest(int[] input, int expected) {
        String message = String.format("for input %s\n", Arrays.toString(input));
        int actual = SmallestIntegerFinder.findSmallestInt(input);
        assertEquals(expected, actual, message);
    }
}
