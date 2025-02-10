package katas.fundamentals.incrementer;

import org.junit.jupiter.api.Test;

import static katas.fundamentals.incrementer.StringIncrementer.incrementNumber;
import static org.junit.jupiter.api.Assertions.*;

class StringIncrementerTest {


// TODO: Replace examples and use TDD by writing your own tests

        private static void doTest(String str, String expected) {
            String actual = assertDoesNotThrow(
                    () -> StringIncrementer.incrementString(str), "Solution thrown an unexpected exception for str=\"" + str + "\"\n\n");
            assertEquals(expected, actual, "Incorrect answer for str=\"" + str + "\"\n\n");
        }


        @Test
        public void exampleTests() {
            doTest("foobar000", "foobar001");
            doTest("foo", "foo1");
            doTest("foobar001", "foobar002");
            doTest("foobar99", "foobar100");
            doTest("foobar099", "foobar100");
            doTest("", "1");
            doTest("foobar00999", "foobar01000");
            doTest("9464568843102", "9464568843103");
            doTest("fo99obar100", "fo99obar101");
            doTest("S|Gj+-y.S2bjSH4+9Se}_P(*!5NKh926spz0\"229126157747667554263895", "S|Gj+-y.S2bjSH4+9Se}_P(*!5NKh926spz0\"229126157747667554263896");
//            doTest("fo99obar99", "fo99obar100");

        }

        @Test
        public void incrementNumberTest() {
            assertEquals("1", incrementNumber("0"));
            assertEquals("2", incrementNumber("1"));
            assertEquals("10", incrementNumber("9"));
            assertEquals("100", incrementNumber("99"));
            assertEquals("1000", incrementNumber("999"));
            assertEquals("002", incrementNumber("001"));
            assertEquals("02", incrementNumber("01"));
        }


}
