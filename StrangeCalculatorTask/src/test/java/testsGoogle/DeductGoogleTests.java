package testsGoogle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import strangecalculator.calculator.CalculatorInterface;
import strangecalculator.calculator.GoogleCalculator;
import strangecalculator.calculator.LocalCalculator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DeductGoogleTests {

    private Double x;
    private Double y;
    private Double expRez;

    public DeductGoogleTests(Double x, Double y, Double expRez) {
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
        CalculatorInterface calculator = new GoogleCalculator();
        Double actRez = calculator.deduct(x, y);
        assertEquals(expRez, actRez);
    }
}

