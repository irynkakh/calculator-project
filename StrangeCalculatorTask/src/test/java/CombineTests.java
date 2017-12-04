import strangecalculator.calculator.CalculatorInterface;
import strangecalculator.calculator.LocalCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CombineTests {

    private Double x;
    private Double y;
    private Double expRez;

    public CombineTests(Double x, Double y, Double expRez) {
        this.x = x;
        this.y = y;
        this.expRez = expRez;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1.0, 1.0, 2.0},
                {-1.0, 1.0, 0.0},
                {1.9, 9.99, 11.89},
                {-99.00, -99.00, -198.00},
                {-100.000, 99.000, -1.000},
                {-0.11, -0.99, -1.1}
        });
    }

    @Test
    public void testCombineMethod() {
        CalculatorInterface calculator = new LocalCalculator();
        Double actRez = calculator.combine(x, y);
        assertEquals(expRez, actRez);
    }
}
