package katas.kyu6;

import java.util.Arrays;

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

 */
public class SuperMarketQueue {

    public static int solveSuperMarketQueue(int[] customers, int n) {

        if (customers.length == 0) {  return 0; }
        if (customers.length < n ) {
            n =  customers.length;
        }
        int mini =  Arrays.stream(customers).sum()/n;

        if (mini < n) { mini = Math.min(n, customers.length) ; }
        return mini;
    }

}
