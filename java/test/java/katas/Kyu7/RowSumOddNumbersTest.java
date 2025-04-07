package katas.Kyu7;

import katas.Kyu7.RowSumOddNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowSumOddNumbersTest {

    @Test
    public void test1() {
        assertEquals(1, RowSumOddNumbers.rowSumOddNumbers(1));
    }

    @Test
    void test_3_5_retrun_8() {
        assertEquals(8, RowSumOddNumbers.rowSumOddNumbers(2));
    }

    @Test
    public void test42() {

        assertEquals(74088, RowSumOddNumbers.rowSumOddNumbers(42));
    }


    @Test
    void getFirstNumber_row1() {
        assertEquals(1, RowSumOddNumbers.getFirstNumber(1));
    }

    @Test
    void getFirstNumber_row2() {
        assertEquals(3, RowSumOddNumbers.getFirstNumber(2));
    }
    @Test
    void getFirstNumber_row3() {
        assertEquals(7, RowSumOddNumbers.getFirstNumber(3));
    }

    @Test
    void getFirstNumber_row4() {
        assertEquals(13, RowSumOddNumbers.getFirstNumber(4));
    }
}
