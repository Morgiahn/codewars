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
}
