package katas.kyu8;

import java.util.Arrays;

public class SmallestIntegerFinder {

    public static int findSmallestInt(int[] args) {
        return Arrays.stream(args).min().orElse(0);
    }


}

/*

    public static int findSmallestInt(int[] args) {
        return IntStream.of(args).min().getAsInt();
    }

    public static int findSmallestInt(int[] args) {
      return Arrays.stream(args).sorted().toArray()[0];
    }

   public static int findSmallestInt(int[] args) {
        Arrays.sort(args);
        return args[0];
    }


    public static int findSmallestInt(int[] args) {
      return Arrays.stream(args).summaryStatistics().getMin();
    }

 */
