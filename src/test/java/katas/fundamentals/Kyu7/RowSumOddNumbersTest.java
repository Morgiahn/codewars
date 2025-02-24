package katas.fundamentals.Kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowSumOddNumbersTest {

    @Test
    public void test1() {
        assertEquals(1, RowSumOddNumbers.rowSumOddNumbers(1));

        assertEquals(74088, RowSumOddNumbers.rowSumOddNumbers(42));
    }

    @Test
    void test_3_5_retrun_8() {
        assertEquals(8, RowSumOddNumbers.rowSumOddNumbers(2));
    }
}