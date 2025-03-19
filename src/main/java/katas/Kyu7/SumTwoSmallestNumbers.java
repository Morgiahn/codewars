package katas.Kyu7;

import java.util.Arrays;

/*

Create a function that returns the sum of the two lowest positive numbers given an array of minimum 4 positive integers.

No floats or non-positive integers will be passed.

For Java, those integers will come as double precision (long).

For example, when an array is passed like [19, 5, 42, 2, 77], the output should be 7.

[10, 343445353, 3453445, 3453545353453] should return 3453455.


 */
public class SumTwoSmallestNumbers {

    public static long sumTwoSmallestNumbers(long[] numbers) {
        //Your solution here
        Arrays.sort(numbers);
        return numbers[0] + numbers[1];
    }
}


/*
// O(n log n)
// stream overhead
  public static long sumTwoSmallestNumbers(final long [] numbers) {
     return Arrays.stream(numbers)
                    .sorted()
                    .limit(2)
                    .sum();
  }


 */

/*
O(n)
public static long sumTwoSmallestNumbers(long[] numbers) {
    long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;

    for (long num : numbers) {
        if (num < min1) {
            min2 = min1;
            min1 = num;
        } else if (num < min2) {
            min2 = num;
        }
    }

    return min1 + min2;
}
 */
