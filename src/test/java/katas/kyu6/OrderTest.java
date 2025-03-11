package katas.kyu6;


import katas.kyu6.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

 class OrderTest {
    @Test
     void test1() {
        assertThat(Order.order("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
    }

    @Test
     void test2() {
        assertThat(Order.order("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    @Test
     void test3() {
        assertThat("Empty input should return empty string", Order.order(""), equalTo(""));
    }
}
