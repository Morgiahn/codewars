package katas.Kyu7;

import katas.Kyu7.Middle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiddleTest {

    @Test
    public void evenTests() {
        assertEquals("es", Middle.getMiddle("test"));
        assertEquals("dd", Middle.getMiddle("middle"));
    }

    @Test
    public void oddTests() {
        assertEquals("t", Middle.getMiddle("testing"));
        assertEquals("A", Middle.getMiddle("A"));
    }
    
}
