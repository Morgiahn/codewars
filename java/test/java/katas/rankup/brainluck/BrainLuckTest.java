package katas.rankup.brainluck;


import static katas.rankup.brainluck.BrainLuck.toCharArray;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BrainLuckTest {

    @Test
    public void testMoveOneCellToRight() {
        assertThat(new BrainLuck(",[->+<]").process("5" + ((char) 255)), is(""));
    }

    @Test
    public void testEchoUntilByte255Encountered() {
        assertThat(new BrainLuck(",+[-.,+]").process("Codewars" + ((char) 255)), is("Codewars"));
    }

    @Test
    public void testEchoUntilByte0Encountered() {
        assertThat(new BrainLuck(",[.[-],]").process("Codewars" + ((char) 0)), is("Codewars"));
    }

    @Test
    public void testTwoNumbersMultiplier() {
        final char[] input = {8, 9};
        assertThat(new BrainLuck(",>,<[>[->+>+<<]>>[-<<+>>]<<<-]>>.").process(String.valueOf(input[0]) + String.valueOf(input[1])), is(String.valueOf((char) (input[0] * input[1]))));
    }

    @Test
    void movePointerForward_simple() {
        assertEquals(4, BrainLuck.movePointerForward(0, toCharArray("..[.].")));
    }
    @Test
    void movePointerForward_double() {
        assertEquals(7, BrainLuck.movePointerForward(0, toCharArray("..[.[*]].")));
    }

    @Test
    void movePointerBackward_double() {
        assertEquals(2, BrainLuck.movePointerBackward(7, toCharArray("..[.[*]].")));
    }


}
