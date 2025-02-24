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

//        ArrayList<Integer> file = makeArray(n);
        return somme(n);
    }

    public static ArrayList<Integer> makeArray(int rows) {
        ArrayList<Integer> file = null;
        int number = 1;
        int row = 0;
        while(row < rows) {
            row ++;
            //
            file = new ArrayList<>();
            while( file.size() < row) {
                number += 2;
                file.add(number);
            }
        }
        return file;
    }

    public static int somme(int rows) {
        ArrayList<Integer> file = null;
        int number = 1;
        int row = 0;
        int total = 0;
        while(row < rows) {
            row ++;
            //
            file = new ArrayList<>();
            total = 0;
            while( file.size() < row) {
                total += number;
                file.add(total);
                number += 2;
            }
        }
        return total;
    }
}
