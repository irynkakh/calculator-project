package strangecalculator.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebCalculator implements CalculatorInterface {

    WebDriver driver;
    By searchBox = By.id("lst-ib");
    By resultBox = By.id("cwos");

    public WebCalculator() {
        this.driver = driver;
    }

    public void setup() {

        driver = new ChromeDriver();

        driver.navigate().to("http://web2.0calc.com/");

    }
    @Override
    public Double combine(Double x, Double y) {
        return null;
    }

    @Override
    public Double deduct(Double x, Double y) {
        return null;
    }

    @Override
    public Double multiply(Double x, Double y) {
        return null;
    }

    @Override
    public Double divide(Double x, Double y) {
        return null;
    }
}