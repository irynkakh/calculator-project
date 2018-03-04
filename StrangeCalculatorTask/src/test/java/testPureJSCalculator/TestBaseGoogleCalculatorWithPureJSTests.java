package testPureJSCalculator;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import strangecalculator.calculator.GoogleCalculatorWithPureJS;

public class TestBaseGoogleCalculatorWithPureJSTests {
    public WebDriver driver;
    public GoogleCalculatorWithPureJS calculator;

    @Before
    public void inicialisate() {
        calculator = new GoogleCalculatorWithPureJS();
    }

    @After
    public void closeBrowser() {
        calculator.close();
    }
}
