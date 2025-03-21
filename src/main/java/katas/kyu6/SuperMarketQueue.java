package katas.kyu6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
There is a queue for the self-checkout tills at the supermarket.

Your task is write a function to calculate the total time required for all the customers to check out!
input

    customers:
        an array of positive integers representing the queue.

        Each integer represents a customer,
        and its value is the amount of time they require to check out.

    n: a positive integer, the number of checkout tills.

output

The function should return an integer, the total time required.

Examples

queueTime([5,3,4], 1)
// should return 12
// because when there is 1 till, the total time is just the sum of the times

queueTime([10,2,3,3], 2)
// should return 10
// because here n=2 and the 2nd, 3rd, and 4th people in the
// queue finish before the 1st person has finished.

queueTime([2,3,10], 2)
// should return 12



Clarifications

    There is only ONE queue serving many tills, and
    The order of the queue NEVER changes, and
    The front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as it becomes free.

N.B. You should assume that all the test input will be valid, as specified above.

P.S. The situation in this kata can be likened to the more-computer-science-related idea of a thread pool, with relation to running multiple processes at the same time: https://en.wikipedia.org/wiki/Thread_pool


 */

public class SuperMarketQueue {

    static void addTillCustomer(int[] tills, LinkedList<Integer> stackFifo) {
        IntStream.range(0, tills.length)
                .filter(i -> tills[i] == 0)
                .forEach(i -> {
                    if (!stackFifo.isEmpty()) {
                        tills[i] = stackFifo.remove();
                    }
                });
    }

    static int collectsFirstCustomerTime(int[] tills, LinkedList<Integer> stackFifo) {
        int minTillValue = Arrays.stream(tills).filter(till -> till > 0).min().orElse(0);
        IntStream.range(0, tills.length)
                .filter(i -> tills[i] >= minTillValue)
                .forEach(i -> tills[i] -= minTillValue);
        return  minTillValue;
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        if (customers.length == 0) {  return 0; }

        int totalTime = 0;
        int[] tills =  new int[n];
        LinkedList<Integer> stackFifo = Arrays.stream(customers).boxed().collect(Collectors.toCollection(LinkedList::new));

        while(!stackFifo.isEmpty()) {
            addTillCustomer(tills, stackFifo);
            totalTime += collectsFirstCustomerTime(tills, stackFifo);
        }
        // remaining customers in tills
        int maxTillValue =  Arrays.stream(tills).filter(till -> till >= 0).max().orElse(Integer.MIN_VALUE);
        totalTime += maxTillValue;
        return totalTime;
    }

}

/*
import java.util.Arrays;
public class SuperMarketQueue {

    public static int solveSuperMarketQueue(int[] customers, int n) {
      int[] result = new int[n];
		  for(int i = 0; i < customers.length; i++){
	    	result[0] += customers[i];
	    	Arrays.sort(result);
	    }
		  return result[n-1];
    }

}
*/
