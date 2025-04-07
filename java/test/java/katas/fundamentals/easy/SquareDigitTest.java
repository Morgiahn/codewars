package katas.fundamentals.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareDigitTest {

    @Test
    void squareDigits() {
        assertEquals(9, new SquareDigit().squareDigits(3));
        assertEquals(811181, new SquareDigit().squareDigits(9119));
        assertEquals(0, new SquareDigit().squareDigits(0));
    }
}