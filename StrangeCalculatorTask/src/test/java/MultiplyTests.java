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
public class MultiplyTests {

    private Double x;
    private Double y;
    private Double expRez;

    public MultiplyTests(Double x, Double y, Double expRez) {
        this.x = x;
        this.y = y;
        this.expRez = expRez;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1.0, 1.0, 1.0},
                {-1.0, 1.0, -1.0},
                {1.00, 0.00, 0.0},
                {-99.00, -99.00, 9801.00},
                {-4.000, 25.000, -100.000},
                {-0.11, -0.99, 0.1089}
        });
    }

    @Test
    public void testMultiplyMethod() {
        CalculatorInterface calculator = new LocalCalculator();
        Double actRez = calculator.multiply(x, y);
        assertEquals(expRez, actRez);
    }
}
