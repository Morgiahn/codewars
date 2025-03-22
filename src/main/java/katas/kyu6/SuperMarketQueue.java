package katas.kyu6;

import java.util.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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

    public static Logger log = Logger.getLogger("SuperMarketQueue");

    static {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            @Override
            public String format(LogRecord record) {
                return String.format("[%s] %s - %s\n",
                        record.getLevel(),
                        record.getLoggerName(),
                        record.getMessage());
            }
        });
        log.setUseParentHandlers(false);
        log.addHandler(handler);
    }

    static class Till {
        int time;
        Till(int time) {
            this.time = time;
        }
        void setTime(int t) { time = t; }
        boolean isAvailable() { return time == 0; }
        void update() {
            time--;
            if (time < 0) { time = 0; }
        }
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {

        if (customers.length == 0) {  return 0; }
        LinkedList<Integer> stackFifo =  new LinkedList<>();
        for(int c : customers) {
            stackFifo.add(c);
        }

        List<Till> tills = new ArrayList<>();
        for (int i =0; i<n;i++) {
            tills.add(new Till(0));
        }

        int totalTime = 0;
        while(!stackFifo.isEmpty() || anyTillIsBusy(tills) ) {
            totalTime++;
            // execution en parallele
            String stills = "";
            for(int i=0; i<n; i++) {
                Till till = tills.get(i);
                // check till
                String operation = " -";
                if (till.isAvailable() && !stackFifo.isEmpty()) {
                    int customerTime = stackFifo.remove();
                    till.setTime(customerTime);
                    operation = "<" + customerTime;
                }
                till.update();
                stills += " till("+i + "):" + operation;
            }

            log.info("round " + totalTime + " " +  stills + " queue : " + stackFifo.size());
            log.info(debugTime( tills, stackFifo, totalTime, n));
        }
        // all customers gone and all tills are free
        return totalTime;
    }

    static boolean anyTillIsBusy(List<Till> tills) {
        for (Till till: tills) {
            if (!till.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    static String debugTime(List<Till> tills, LinkedList<Integer> stackFifo, int totalTime, int n) {

        String stills = "";
        for(int i = 0; i < n; i++ ) {
            stills += " till("+i + "): " + tills.get(i).time;
        }
        return "round " + totalTime + " " + stills + " queue : " + stackFifo.size();
    }


}
