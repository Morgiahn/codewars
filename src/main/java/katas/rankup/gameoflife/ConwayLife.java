package katas.rankup.gameoflife;

import java.util.*;
import java.util.function.BiFunction;
import java.util.logging.Logger;

/*
Given a 2D array and a number of generations, compute n timesteps of Conway's Game of Life.
https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

The rules of the game are:

    Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
    Any live cell with more than three live neighbours dies, as if by overcrowding.
    Any live cell with two or three live neighbours lives on to the next generation.
    Any dead cell with exactly three live neighbours becomes a live cell.

Each cell's neighborhood is the 8 cells immediately around it (i.e. Moore Neighborhood).
https://en.wikipedia.org/wiki/Moore_neighborhood

 The universe is infinite in both the x and y dimensions
 and all cells are initially dead - except for those specified in the arguments.
 The return value should be a 2d array cropped around all of the living cells.
 (If there are no living cells, then return [[]].)

For illustration purposes, 0 and 1 will be represented as ░░ and ▓▓ blocks respectively
(PHP: plain black and white squares).
You can take advantage of the htmlize function to get a text representation of the universe, e.g.:

System.out.println(LifeDebug.htmlize(cells));

 */
public class ConwayLife {
    static Logger log = Logger.getLogger(ConwayLife.class.getName());

    public static int[][] getGeneration(int[][] cells, int generations) {

        // your code goes here
//        Map<Integer, Boolean> store = new HashMap<>();
//        int size = cells[0].length;
//        for(int y=0; y < cells.length; y++) {
//            for(int x=0; x <cells[0].length; x++) {
//                if (cells[y][x] == 1) {
//                    store.put(x + y* cells.length, true);
//                }
//            }
//        }


        for(int i=0; i < generations; i++) {
            cells = generate(cells);
            System.out.println("generation: " + i);
            System.out.println(ConwayLife.gliderToString(cells));
        }

        return cells;
    }

    public static int[][] generate(int[][] cells) {
        // rules
        /*
            Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
            Any live cell with more than three live neighbours dies, as if by overcrowding.
            Any live cell with two or three live neighbours lives on to the next generation.
            Any dead cell with exactly three live neighbours becomes a live cell.
        */
        BiFunction<Integer, Integer, Integer> diesByUnderpopulation = (state, lives) -> state == 1 && lives < 2 ? 0 : null;
        BiFunction<Integer, Integer, Integer > diesByOvercrowding = (state, lives) -> state == 1 && lives > 3 ? 0 : null;
        BiFunction<Integer, Integer, Integer > survive = (state, lives) -> state == 1  && (lives == 2 || lives == 3) ? 1 : null;
        BiFunction<Integer, Integer, Integer > resurect = (state, lives) -> state == 0 && lives == 3 ? 1: null;

        final int SIZE = cells.length;
        // your code goes here
        int[][] generatedCells = new int[SIZE][SIZE];
        for(int y=0; y < SIZE; y++) {
            for(int x=0; x < SIZE; x++) {
                int lives = liveNeighboursCount(x , y, cells);
                log.info("y "+ y + " x " + x + " lives " + lives + " cell: "+ cells[y][x]);
                if (diesByUnderpopulation.apply(cells[y][x], lives) != null) {
                    generatedCells[y][x] = 0;
                    log.info("diesByUnderpopulation");
                }
                if (diesByOvercrowding.apply(cells[y][x], lives) != null ){
                    generatedCells[y][x] = 0;
                    log.info("diesByOvercrowding");
                }
                if (survive.apply(cells[y][x], lives) != null)  {
                    generatedCells[y][x] = 1;
                    log.info("survive");
                }
                if (resurect.apply(cells[y][x], lives) != null){
                    generatedCells[y][x] = 1;
                    log.info("resurect");
                }
                log.info(LifeDebug.htmlize(generatedCells));
            }
        }
        return generatedCells;
    }


    public static int[][] neighboursArray(int cx, int cy, int size, int[][] cells) {
        int miny = Math.max(0, cy -1);
        int maxy = Math.min(cy+2, cells.length) ;
        maxy = Math.min(cy+2, maxy) ;
//        if (maxy > cy+2) { maxy = cy +2; }
        int newsize = maxy - miny;
        int[][] res = new int[newsize][newsize];
        int resy = 0;
        for (int y = miny; y < maxy; y++) {
            res[resy] = ConwayLife.subArray(cx, cells[y]);
            resy++;
        }
        return res;
    }

    public static int[] subArray(int x, int[] cells) {
        int start = Math.max(0, x - 1);
        int end = Math.min(cells.length, x +2);
        return Arrays.copyOfRange(cells, start, end );
    }

    public static int liveNeighboursCount(int cx, int cy, int[][] fullCells) {
        int[][] cells = ConwayLife.neighboursArray(cx, cy, 3, fullCells);
        int count = 0;
        for (int y=0; y< cells.length; y++) {
            for (int x= 0; x < cells[y].length; x++) {
                count += cells[y][x] > 0 ? 1 : 0;
            }
        }
        return  count - fullCells[cy][cx];
    }

    public static String gliderToString(int[][] glider) {
        StringBuilder sb = new StringBuilder();
        for (int[] y : glider) {
            for (int x : y) {
                sb.append(x > 0 ? "*" : ".");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static String storeToString(Map<Integer, Boolean> store, int size) {
        StringBuilder sb = new StringBuilder();
//todo
        return sb.toString();
    }


}
