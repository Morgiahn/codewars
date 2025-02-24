package katas.rankup.gameoflife;

import static java.util.Arrays.deepEquals;

public class LifeDebug {
    public static void print(int[][] glider) {
        for (int[] y : glider) {
            for (int x : y) {
                System.out.print(x > 0 ? "*" : ".");
            }
            System.out.println("");
        }
    }

    public static String htmlize(int[][] glider) {
        if (glider == null) {
            return "empty glider !";
        }
        StringBuilder sb = new StringBuilder();
        for (int[] y : glider) {
            for (int x : y) {
                sb.append(x > 0 ? "*" : ".");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static boolean equals(int[][] res, int[][] glider) {
        return deepEquals(res, glider);
    }


}
