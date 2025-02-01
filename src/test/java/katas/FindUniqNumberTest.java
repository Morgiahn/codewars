package katas;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindUniqNumberTest {

    private double precision = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1.0, FindUniqNumber.findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, FindUniqNumber.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
        assertEquals(3.0, FindUniqNumber.findUniq(new double[]{3, 1, 1, 2, 1, 1, 2}), precision);
        assertEquals(4.0, FindUniqNumber.findUniq(new double[]{3, 1, 1, 2, 1, 1, 2, 3, 4}), precision);
    }
}