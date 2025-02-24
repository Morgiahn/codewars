package katas.fundamentals.Kyu7;

import java.util.ArrayList;
import java.util.stream.IntStream;

/*
Ginven the triangle of consecutive odd numbers:

             1
          3     5
       7     9    11
   13    15    17    19
21    23    25    27    29
...


 */
public class RowSumOddNumbers {
    public static int rowSumOddNumbers(int n) {
        int start = n * (n  - 1) + 1;
        return  totalNumbers(start, n);
    }

    public static int totalNumbers(int number, int row) {
        int  total = 0;
        for (int numberInRows = 0; numberInRows < row; numberInRows++) {
            total += number;
            number += 2;
        }
        return total;
    }

    public static int getFirstNumber(int rows) {
        return rows * (rows  - 1) + 1;
    }
}
