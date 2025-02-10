package katas.fundamentals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindUniqNumberTest {

    private final double precision = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1.0, FindUniqNumber.findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, FindUniqNumber.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
        assertEquals(3.0, FindUniqNumber.findUniq(new double[]{3, 1, 1, 2, 1, 1, 2}), precision);
        assertEquals(4.0, FindUniqNumber.findUniq(new double[]{3, 1, 1, 2, 1, 1, 2, 3, 4}), precision);
    }
}
