package testsDerivative;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CombineDerivativeTests extends TestBaseDerivativeCalculator {
    private Double x;
    private Double y;
    private Double expRez;

    public CombineDerivativeTests (Double x, Double y, Double expRez) {
        this.x = x;
        this.y = y;
        this.expRez = expRez;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1.0, 1.0, 2.0},
                {-1.0, 1.0, 0.0},
                {-99.00, -99.00, -198.00},
                {-100.000, 99.000, -1.000},
        });
    }

    @Test
    public void testCombineMethod() {
        Double actRez = calculator.combine(x, y);
        assertEquals(expRez, actRez);
    }
}
