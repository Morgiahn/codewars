package katas.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.deepEquals;
import static org.junit.jupiter.api.Assertions.*;

class ConwayLifeTest {

    private  int[][] glider33;
    private  int[][] glider33_gen1;
    private  int[][] glider33_gen2;
    private  int[][] gliderTest;
    private  int[] array2D;
    @BeforeEach
    void setup() {
        glider33 = new int[][]{ {1,0,0},
                                {0,1,1},
                                {1,1,0}};

        glider33_gen1 = new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1}};
        glider33_gen2 = new int[][]{
                {1,0,1},
                {0,1,1},
                {0,1,0}};

        gliderTest = new int[][]{ {1,2,3}, {4,5,6}, {7,8,9}};
        array2D = new int[] {1,2,3,4,5,6};
    }

    @Test
    public void testGlider() {
        int[][][] gliders = {  glider33, glider33_gen1 };
        System.out.println("Glider");
        LifeDebug.print(gliders[0]);
        int[][] res = ConwayLife.getGeneration(gliders[0], 1);
        assertTrue(LifeDebug.equals(res, gliders[1]), "Got \n" + LifeDebug.htmlize(res) + "\ninstead of\n" + LifeDebug.htmlize(gliders[1]));
    }

    @Test
    public void testGlider_rule1() {
        int[][][] gliders = {  glider33_gen1, glider33_gen2 };
        int[][] res = ConwayLife.getGeneration(gliders[0], 1);
        assertTrue(LifeDebug.equals(res, gliders[1]), "Got \n" + LifeDebug.htmlize(res) + "\ninstead of\n" + LifeDebug.htmlize(gliders[1]));
    }

    @Test
    void liveNeighboursCount_regular11() {
        assertEquals(4, ConwayLife.liveNeighboursCount(1,1, glider33));
    }
    @Test
    void liveNeighboursCount_regular00() {
        assertEquals(1, ConwayLife.liveNeighboursCount(0,0, glider33));
    }
    @Test
    void liveNeighboursCount_regular22() {
        assertEquals(3, ConwayLife.liveNeighboursCount(2,2, glider33));
    }

    @Test
    void neighboursArray_11() {
        int[][] actual = ConwayLife.neighboursArray(1,1,3,gliderTest);
         assertTrue(deepEquals(gliderTest, ConwayLife.neighboursArray(1,1,3,gliderTest)));
    }

    @Test
    void neighboursArray_22() {
        assertTrue(deepEquals(new int[][]{{5,6},{8,9}}, ConwayLife.neighboursArray(2,2,3,gliderTest)));
    }
    @Test
    void neighboursArray_00() {
        assertTrue(deepEquals(new int[][]{{1,2},{4,5}}, ConwayLife.neighboursArray(0,0,3,gliderTest)));
    }
    @Test
    void neighboursArray_02() {
        assertTrue(deepEquals(new int[][]{{4,5}, {7,8}}, ConwayLife.neighboursArray(0,2,3,gliderTest)));
    }


    @Test
    void subArrayTest() {
        assertTrue(Arrays.equals(new int[]{}, ConwayLife.subArray(-2, array2D)));
        assertTrue(Arrays.equals(new int[]{1}, ConwayLife.subArray(-1, array2D)));
        assertTrue(Arrays.equals(new int[]{1,2}, ConwayLife.subArray(0, array2D)));
        assertTrue(Arrays.equals(new int[]{1,2,3}, ConwayLife.subArray(1, array2D)));
        assertTrue(Arrays.equals(new int[]{2,3,4}, ConwayLife.subArray(2, array2D)));
        assertTrue(Arrays.equals(new int[]{5,6}, ConwayLife.subArray(5, array2D)));
        assertTrue(Arrays.equals(new int[]{6}, ConwayLife.subArray(6, array2D)));
        assertTrue(Arrays.equals(new int[]{}, ConwayLife.subArray(7, array2D)));
    }


//    public static void doTestSubArray(int[][] expected, int cx, int cy, int size, int[][] cells) {
//        int[][] actual = assertDoesNotThrow(
//                () -> ConwayLife.subArray(cx, cy, size, cells),
//                "Solution thrown an unexpected exception for");
//    }



}

