package katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Rot13Test {
    @Test
    void rotate_a() {
        assertEquals("n", Rot13.rot13("a"));
    }
    @Test
    void rotate_z() {
        assertEquals("m", Rot13.rot13("z"));
    }    @Test
    void rotate_y() {
        assertEquals("l", Rot13.rot13("y"));
    }

    @Test
    void rotateUpperZ() {
        assertEquals("M", Rot13.rot13("Z"));
    }
    @Test
    void rotateUpperY() {
        assertEquals("L", Rot13.rot13("Y"));
    }
    @Test
    void rotateUpperM() {
        assertEquals("Z", Rot13.rot13("M"));
    }

    @Test
    @Order(1)
    @DisplayName("Strings with lower letters only")
    void testSomething1() {
        Assertions.assertEquals("uryyb", Rot13.rot13("hello"), "For input: `hello`");
    }

    @Test
    @Order(2)
    @DisplayName("Strings with upper and lower case letters")
    void testSomething2() {
        Assertions.assertEquals("UryybJbeyq", Rot13.rot13("HelloWorld"), "For input: `HelloWorld`");
    }

    @Test
    @Order(3)
    @DisplayName("Strings with spaces and special characters")
    void testSomething3() {
        Assertions.assertEquals("Uryyb Jbeyq!", Rot13.rot13("Hello World!"), "For input: `Hello World!`");
    }

    @Test
    @Order(4)
    @DisplayName("Strings with only special characters, digits and spaces")
    void testSomething4() {
        Assertions.assertEquals("123@#!!#@  33", Rot13.rot13("123@#!!#@  33"), "For input: `123@#!!#@  33`");
    }

    @Test
    @Order(5)
    @DisplayName("Strings with only special characters, digits, spaces and letters")
    void testSomething5() {
        Assertions.assertEquals("J3 ne3 va lr@e 2023$$$!äöü", Rot13.rot13("W3 ar3 in ye@r 2023$$$!äöü"), "For input: `W3 ar3 in ye@r 2023$$$!äöü`");
    }
}