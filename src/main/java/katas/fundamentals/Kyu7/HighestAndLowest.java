package katas.fundamentals.Kyu7;

import java.util.Arrays;
import java.util.List;

/*
In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
Examples

highAndLow("1 2 3 4 5") // return "5 1"
highAndLow("1 2 -3 4 5") // return "5 -3"
highAndLow("1 9 3 4 -5") // return "9 -5"

Notes

    All numbers are valid Int32, no need to validate them.
    There will always be at least one number in the input string.
    Output string must be two numbers separated by a single space, and highest number is first.



 */
public class HighestAndLowest {
    public static String highAndLow(String numbers) {
        // Code here or
//        Integer high = null, low = null;
//        for (String number: numbers.split("\\s+")) {
//            int current = Integer.parseInt(number);
//            if (high == null || high < current) {
//                high  = current;
//            }
//            if (low == null || low > current) {
//                low  = current;
//            }
//        }
//        return "%d %d".formatted(high, low);

        List<Integer> nums = Arrays.stream(numbers.split(" ")).map(Integer::parseInt).sorted().toList();
        return "%s %s".formatted(nums.getLast(), nums.getFirst());

    }
}

/*
        int [] result = Arrays.stream(numbers.split("\\s+"))
                .map( Integer::parseInt)
                .collect( () -> new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}, // Supplier
                        (arr , y) -> {
                            arr[0] = arr[0] < y ? y: arr[0];
                            arr[1] = arr[1] > y ? y : arr[1]; },
                        (a, b) -> {
                            a[0] = Math.max(a[0], b[0]); // Combine max
                            a[1] = Math.min(a[1], b[1]); // Combine min
                        }
                );

        return "%d %d".formatted(result[0], result[1]);
 */

/*
//https://www.geeksforgeeks.org/intstream-summarystatistics-java/

  static String highAndLow(String numbers) {
    var stats = stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
    return stats.getMax() + " " + stats.getMin();
  }
 */

/*
 public static String highAndLow(String numbers) {
        List<Integer> nums = Arrays.stream(numbers.split(" ")).map(Integer::parseInt).toList();
        return "%s %s".formatted(Collections.max(nums), Collections.min(nums));
    }

 */