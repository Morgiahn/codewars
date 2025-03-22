package katas.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperMarketQueueTest {

    @Test
    void normalCondition() {
        assertEquals(9, SuperMarketQueue.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2), "For customers {2, 2, 3, 3, 4, 4} and 2 tills");
    }

    @Test
    void emptyWaitingQueue() {
        assertEquals(0, SuperMarketQueue.solveSuperMarketQueue(new int[] {}, 1), "For no customers and 1 till");
    }

    @Test
    void singleTillManyCustomers() {
        assertEquals(15, SuperMarketQueue.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1), "For customers {1, 2, 3, 4, 5} and 1 till");
    }

    @Test
    void custumer2_and5tills() {
        assertEquals(2, SuperMarketQueue.solveSuperMarketQueue(new int[]{2}, 5));
    }

    // For customers [6, 1, 1, 2, 5, 1, 7, 1, 7, 6, 2, 2, 7, 3, 4] and 5 tills ==> expected: <14> but was: <15>
    @Test
    void random1() {
        assertEquals(14, SuperMarketQueue.solveSuperMarketQueue(new int[]{6, 1, 1, 2, 5, 1, 7, 1, 7, 6, 2, 2, 7, 3, 4}, 5));
    }

    // For customers [1, 5, 1, 5, 7, 2, 4, 3, 3, 2, 2, 5, 3, 2, 6, 7, 3] and 2 tills ==> expected: <31> but was: <32>
    @Test
    void random2() {
        assertEquals(31, SuperMarketQueue.solveSuperMarketQueue(new int[]{1, 5, 1, 5, 7, 2, 4, 3, 3, 2, 2, 5, 3, 2, 6, 7, 3}, 2));
    }

    //For customers {29, 18, 6, 23, 25, 29, 24, 17, 10, 8, 8, 22, 20, 16, 13, 17, 7, 21, 7, 11, 18, 26, 25, 1, 18, 29, 16, 26, 7, 11, 13, 20, 12, 6, 23, 3, 10, 9, 8, 5, 6, 18, 19, 26, 5, 15, 4, 15, 1, 4} and 7 tills ==> expected: <113> but was: <119>
    @Test
    void random3() {
        assertEquals(113, SuperMarketQueue.solveSuperMarketQueue(new int[]{29, 18, 6, 23, 25, 29, 24, 17, 10, 8, 8, 22, 20, 16, 13, 17, 7, 21, 7, 11, 18, 26, 25, 1, 18, 29, 16, 26, 7, 11, 13, 20, 12, 6, 23, 3, 10, 9, 8, 5, 6, 18, 19, 26, 5, 15, 4, 15, 1, 4}, 7));
    }

}

/*
    For customers [6, 1, 1, 2, 5, 1, 7, 1, 7, 6, 2, 2, 7, 3, 4] and 5 tills ==> expected: <14> but was: <15>

t1      6, 1, 1, 2, 5, 1, 7, 1, 7, 6,               2, 2, 7, 3, 4
t2                                                  1  1  6  2  3
t3                                                  0  0  5   1 2


[INFO] SuperMarketQueue - round 1  till(0): 3 till(1): 3 queue : 4
[INFO] SuperMarketQueue - round 2  till(0): 2 till(1): 2 queue : 4
[INFO] SuperMarketQueue - round 3  till(0): 1 till(1): 1 queue : 4
[INFO] SuperMarketQueue - round 4  till(0): 0 till(1): 0 queue : 4
[INFO] SuperMarketQueue - round 5  till(0): 2 till(1): 2 queue : 2
[INFO] SuperMarketQueue - round 6  till(0): 1 till(1): 1 queue : 2
[INFO] SuperMarketQueue - round 7  till(0): 0 till(1): 0 queue : 2
[INFO] SuperMarketQueue - round 8  till(0): 1 till(1): 1 queue : 0
[INFO] SuperMarketQueue - round 9  till(0): 0 till(1): 0 queue : 0


[INFO] SuperMarketQueue - round 1  till(0): 3 till(1): 2 till(2): 6 till(3): 1 till(4): 1 queue : 10
[INFO] SuperMarketQueue - round 2  till(0): 2 till(1): 1 till(2): 5 till(3): 0 till(4): 0 queue : 10
[INFO] SuperMarketQueue - round 3  till(0): 1 till(1): 0 till(2): 4 till(3): 5 till(4): 6 queue : 8
[INFO] SuperMarketQueue - round 4  till(0): 0 till(1): 0 till(2): 3 till(3): 4 till(4): 5 queue : 7
[INFO] SuperMarketQueue - round 5  till(0): 6 till(1): 0 till(2): 2 till(3): 3 till(4): 4 queue : 5
[INFO] SuperMarketQueue - round 6  till(0): 5 till(1): 4 till(2): 1 till(3): 2 till(4): 3 queue : 4
[INFO] SuperMarketQueue - round 7  till(0): 4 till(1): 3 till(2): 0 till(3): 1 till(4): 2 queue : 4
[INFO] SuperMarketQueue - round 8  till(0): 3 till(1): 2 till(2): 1 till(3): 0 till(4): 1 queue : 3
[INFO] SuperMarketQueue - round 9  till(0): 2 till(1): 1 till(2): 0 till(3): 0 till(4): 0 queue : 2
[INFO] SuperMarketQueue - round 10  till(0): 1 till(1): 0 till(2): 0 till(3): 5 till(4): 0 queue : 0
[INFO] SuperMarketQueue - round 11  till(0): 0 till(1): 0 till(2): 0 till(3): 4 till(4): 0 queue : 0
[INFO] SuperMarketQueue - round 12  till(0): 0 till(1): 0 till(2): 0 till(3): 3 till(4): 0 queue : 0
[INFO] SuperMarketQueue - round 13  till(0): 0 till(1): 0 till(2): 0 till(3): 2 till(4): 0 queue : 0
[INFO] SuperMarketQueue - round 14  till(0): 0 till(1): 0 till(2): 0 till(3): 1 till(4): 0 queue : 0
[INFO] SuperMarketQueue - round 15  till(0): 0 till(1): 0 till(2): 0 till(3): 0 till(4): 0 queue : 0

 */