package katas.fundamentals;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


public class FindUniqNumber {
    private static double precision = 0.0000000000001;

    public static double findUniq(double arr[]) {
        // Do the magic
//        Arrays.sort(arr);
//        double found = 0;
//        int count = 0;
//        for(int i=1; i < arr.length; i++ ) {
//            if (doubleEquals(arr[i-1],  arr[i]))  {
//                count++;
//            } else {
//                count = 1;
//                found = arr[i];
//            }
//        }
//        return found;
        Map<Double, Long> frq = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        return frq.entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst().orElse(Double.MAX_VALUE);

    }

    public static boolean doubleEquals(double a, double b) {
        return Math.abs(a - b) <= precision;
    }

}

/*
    public static double findUniq(double[] arr) {
      Arrays.sort(arr);
      return arr[0] == arr[1] ? arr[arr.length-1]:arr[0];
    }
}

 */
