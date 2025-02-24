package katas.fundamentals.kyu6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XbonacciTest {

    private Xbonacci variabonacci;

    @BeforeEach
    void setUp() throws Exception {
        variabonacci = new Xbonacci();
    }

    @AfterEach
    void tearDown() throws Exception {
        variabonacci = null;
    }

    private double precision = 1e-10;

    @Test
     void sampleTests() {
<<<<<<< Updated upstream
=======
//        assertArrayEquals(new double []{}, variabonacci.tribonacci(new double []{1.0, 2.0, 3.0},0), precision);
>>>>>>> Stashed changes
        assertArrayEquals(new double []{1,1,1,3,5,9,17,31,57,105}, variabonacci.tribonacci(new double []{1,1,1},10), precision);
        assertArrayEquals(new double []{0,0,1,1,2,4,7,13,24,44}, variabonacci.tribonacci(new double []{0,0,1},10), precision);
        assertArrayEquals(new double []{0,1,1,2,4,7,13,24,44,81}, variabonacci.tribonacci(new double []{0,1,1},10), precision);
    }
<<<<<<< Updated upstream
=======

    @Test
    void test_3_numbers() {
        assertArrayEquals(new double []{17.0}, variabonacci.tribonacci(new double []{17.0, 2.0, 5.0},1), precision);

    }
>>>>>>> Stashed changes
    

}
/*
Log
[17.0, 2.0, 5.0] and n: 1

Testing for signature: [6.0, 18.0, 7.0] and n: 8
Testing for signature: [11.0, 20.0, 19.0] and n: 10
Testing for signature: [12.0, 11.0, 3.0] and n: 25
Testing for signature: [19.0, 1.0, 20.0] and n: 3
Testing for signature: [3.0, 2.0, 8.0] and n: 16
Testing for signature: [9.0, 6.0, 11.0] and n: 27
Testing for signature: [2.0, 18.0, 9.0] and n: 0
 */
