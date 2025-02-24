package katas.fundamentals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class WhichAreInTest {

    @Test
    public void test1() {
        String a[] = new String[]{ "arp", "live", "strong" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String r[] = new String[] { "arp", "live", "strong" };
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }

    // Cette méthode génère les arguments pour le test
    private static Stream<Arguments> elements() {
        return Stream.of(
                Arguments.of(
                        new String[]{"cod","code","wars","ewar","pillow","bed","phht"},
                        new String[]{"lively","alive","harp","sharp","armstrong","codewars"},
                        new String[]{"cod","code", "ewar" , "wars"})
        );
    }

    @ParameterizedTest
    @MethodSource("elements") // Nom de la méthode qui fournit les arguments
    public void test2(String[] a1, String[] a2,  String[] r) {
        assertArrayEquals(r, WhichAreIn.inArray(a1, a2));
    }
}
