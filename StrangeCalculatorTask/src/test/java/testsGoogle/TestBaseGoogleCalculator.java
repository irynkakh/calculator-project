package testsGoogle;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import strangecalculator.calculator.GoogleCalculator;

public abstract class TestBaseGoogleCalculator {
    public WebDriver driver;
    public GoogleCalculator calculator;

    @Before
    public void inicialisate() {
        calculator = new GoogleCalculator();
    }

    @After
    public void closeBrowser() {
        calculator.close();
    }
}
