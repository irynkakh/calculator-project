package testsWeb;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import strangecalculator.calculator.WebCalculator;

public class TestBaseWebCalculator{
        public WebDriver driver;
        public WebCalculator calculator;

        @Before
        public void inicialisate() {
            calculator = new WebCalculator();
        }

        @After
        public void closeBrowser() {
            calculator.close();
        }
}
