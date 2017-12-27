package testsWeb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DeductWebTests extends TestBaseWebCalculator {
    private Double x;
    private Double y;
    private Double expRez;

    public DeductWebTests(Double x, Double y, Double expRez) {
        this.x = x;
        this.y = y;
        this.expRez = expRez;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1.0, 1.0, 0.0},
                {-1.0, 1.0, -2.0},
                {-1.9, -9.99, 8.09},
                {-99.00, 99.00, -198.00},
                {100.000, 99.000, 1.000},
                {-0.11, -0.99, 0.88}
        });
    }

    @Test
    public void testDeductMethod() {
        Double actRez = calculator.deduct(x, y);
        assertEquals(expRez, actRez);
    }
}