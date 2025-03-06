package katas.fundamentals.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirReductionTest {

    @Test
    void testNS() {
        assertArrayEquals(
                new String[]{},
                DirReduction.dirReduc(new String[]{"NORTH","SOUTH"}));
    }

    @Test
    void testSN() {
        assertArrayEquals(
                new String[]{},
                DirReduction.dirReduc(new String[]{"SOUTH", "NORTH"}));
    }

    @Test
    void testEW() {
        assertArrayEquals(
                new String[]{},
                DirReduction.dirReduc(new String[]{"EAST", "WEST"}));
    }

    @Test
    void testWE() {
        assertArrayEquals(
                new String[]{},
                DirReduction.dirReduc(new String[]{ "WEST", "EAST"}));
    }

    @Test
    void testWEE() {
        String[] actual = DirReduction.dirReduc(new String[]{ "WEST", "EAST", "EAST"});
        String[] expected = new String[]{"EAST"};
        assertArrayEquals(expected, actual);

    }

    @Test
    void testWWEE() {
        assertArrayEquals(
                new String[]{},
                DirReduction.dirReduc(new String[]{ "WEST", "WEST", "EAST", "EAST"}));
    }

    @Test
    void testSNWWEE() {
        assertArrayEquals(
                new String[]{},
                DirReduction.dirReduc(new String[]{"SOUTH", "NORTH", "WEST", "WEST", "EAST", "EAST"}));
    }



    @Test
    void testSimpleDirReduc1() {
        assertArrayEquals(
                new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
    }

    @Test
    void testSimpleDirReduc2() {
        assertArrayEquals(
                new String[]{},
                DirReduction.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
    }

}
