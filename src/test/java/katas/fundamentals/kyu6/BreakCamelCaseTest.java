package katas.fundamentals.kyu6;

import katas.kyu6.BreakCamelCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreakCamelCaseTest {


    @Test
    public void tests() {
        assertEquals( "camel Casing", BreakCamelCase.camelCase("camelCasing"));
        assertEquals( "camel Casing Test", BreakCamelCase.camelCase("camelCasingTest"));
        assertEquals(  "camelcasingtest", BreakCamelCase.camelCase("camelcasingtest"));
    }

}
