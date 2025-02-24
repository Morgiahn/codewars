package katas.fundamentals.Kyu7;

import java.util.ArrayList;
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

        return somme(n);
    }

    public static int somme(int rows) {
        int number = 1;
        int row = 0;
        int total = 0;
        while(row < rows) {
            row ++;
            total = 0;
            for (int numberInRows = 0; numberInRows < row; numberInRows++) {
                total += number;
                number += 2;
            }
        }
        return total;
    }
}
