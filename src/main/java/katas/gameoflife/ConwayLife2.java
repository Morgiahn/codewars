package katas.gameoflife;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ConwayLife2 {
    public static int[][] getGeneration(int[][] cells, int generations) {
        // your code goes here

        for(int i=0; i < generations; i++) {
//            cells = generate(cells);
            System.out.println("generation: " + i);
            System.out.println(ConwayLife.gliderToString(cells));
        }
        return cells;
    }

}

