package katas.Kyu7;

/*
You are given an odd-length array of integers,
in which all of them are the same, `
except for one single number.

Complete the method which accepts such an array, and returns that single different number.

The input array will always be valid! (odd-length >= 3)
Examples

[1, 1, 2] ==> 2
[17, 17, 3, 17, 17, 17, 17] ==> 3


 */
public class Stray {
    static int stray(int[] numbers) {
        if (numbers.length == 1) {
            return  numbers[0];
        }
        int countFirst = 0;
        int countSecond = 0;
        int second = 0;
        for (int number: numbers) {
            if (number == numbers[0]) {
                countFirst++;
            } else {
                countSecond++;
                second = number;
            }
        }
        return countFirst < countSecond ? numbers[0] : second;
    }
}

/*

  static int stray(int[] numbers) {
    if (numbers[0] != numbers[1] && numbers[0] != numbers[2]) return numbers[0];
    for (int i : numbers) if (i != numbers[0]) return i;
    return 0;
  }


  static int stray(int[] numbers) {
    return Arrays.stream(numbers).reduce(0, (a, b) -> a ^ b);
  }


   static int stray(int[] numbers) {
       int sum=0;
       for(int c :numbers)
            sum^=c ;
   return sum;
  }

    sum = 0 (initialisation)
    sum ^= 1 → 0 ^ 1 = 1
    sum ^= 1 → 1 ^ 1 = 0 (car 1 ^ 1 = 0)
    sum ^= 2 → 0 ^ 2 = 2
    Le code fonctionne seulement si tous les nombres sauf un apparaissent un nombre pair de fois.
 */
