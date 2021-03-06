package testsLocal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import strangecalculator.calculator.CalculatorInterface;
import strangecalculator.calculator.LocalCalculator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DevideTests {

    private Double x;
    private Double y;
    private Double expRez;

    public DevideTests(Double x, Double y, Double expRez) {
        this.x = x;
        this.y = y;
        this.expRez = expRez;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1.0, 1.0, 1.0},
                {-1.0, 1.0, -1.0},
                {1.00, 1.00, IllegalArgumentException.class},
                {-99.00, -99.00, 1.00},
                {-100.000, 25.000, -4.000},
                {-0.11, -0.99, 0.11111111111111112}
        });
    }

    @Test
    public void testDevideMethod() {
        CalculatorInterface calculator = new LocalCalculator();
        Double actRez = calculator.divide(x, y);
        assertEquals(expRez, actRez);
    }
}
