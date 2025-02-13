package katas.fundamentals.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortDescOrderTest {

    @Test
    public void test_01() {
        assertEquals(0, SortDescOrder.sortDesc(0));
    }

    @Test
    public void test_02() {
        assertEquals(51, SortDescOrder.sortDesc(15));
    }


    @Test
    public void test_03() {
        assertEquals(987654321, SortDescOrder.sortDesc(123456789));
    }
}
