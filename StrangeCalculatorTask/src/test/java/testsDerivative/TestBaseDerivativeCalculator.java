package testsDerivative;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import strangecalculator.calculator.DerivativeCalculator;

public class TestBaseDerivativeCalculator {
    public WebDriver driver;
    public DerivativeCalculator calculator;

    @Before
    public void inicialisate() {
        calculator = new DerivativeCalculator();
    }

    @After
    public void closeBrowser() {
        calculator.close();
    }
}
