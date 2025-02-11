package katas.fundamentals.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class stringToNumberTest {

    @Test
    public void test1(){
        assertEquals( 1234 , stringToNumber.convert("1234"));
    }
    @Test
    public void test2(){
        assertEquals( 605 , stringToNumber.convert("605"));
    }
    @Test
    public void test3(){
        assertEquals(1405 , stringToNumber.convert("1405"));
    }
    @Test
    public void test4(){
        assertEquals( -7 , stringToNumber.convert("-7"));
    }

}
