package katas.rankup.gameoflife;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LifeDebugTest {

    @Test
    public void testEquals_same_glider() {
        int[][] glider =
                {{1,0,0},
                        {0,1,1},
                        {1,1,0}};
        assertTrue(glider.equals(glider));
    }

    @Test
    public void testEquals_diff_glider() {
        int[][] glider =
                {{1,0,0},
                        {0,1,1},
                        {1,1,0}};

        int[][] glider1 =
                {{0,0,0},
                        {0,1,1},
                        {1,1,0}};
        assertFalse(glider.equals(glider1));
    }

}
