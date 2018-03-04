package testsIframeCalculator;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import strangecalculator.calculator.CalculatorWithIframe;

public abstract class TestBaseForIframeCalculator {
    public WebDriver driver;
    public CalculatorWithIframe calculator;

    @Before
    public void inicialisate() {
        calculator = new CalculatorWithIframe();
    }

    @After
    public void closeBrowser() {
        calculator.close();
    }
}
