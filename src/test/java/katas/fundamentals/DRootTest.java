package katas.fundamentals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DRootTest {

    @Test
    public void Test1() {
        assertEquals( 7, DRoot.digital_root(16));
    }
    @Test
    public void Test2() {
        assertEquals( 6, DRoot.digital_root(456));
    }

    //453529
    @Test
    public void Test3() {
        assertEquals( 1, DRoot.digital_root(453529));
    }
}
