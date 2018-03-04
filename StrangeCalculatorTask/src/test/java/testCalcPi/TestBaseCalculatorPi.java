package testCalcPi;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import strangecalculator.calculator.CalculatorPi;

public abstract class TestBaseCalculatorPi {
    public WebDriver driver;
    public CalculatorPi calculator;

    @Before
    public void inicialisate() {
        calculator = new CalculatorPi();
    }

    @After
    public void closeBrowser() {
        calculator.close();
    }
}
