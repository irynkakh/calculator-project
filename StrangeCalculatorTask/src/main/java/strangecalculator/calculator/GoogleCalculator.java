package strangecalculator.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleCalculator implements CalculatorInterface {
    private WebDriver driver;
    private By searchBox = By.id("lst-ib");
    private By resultBox = By.id("cwos");
    public GoogleCalculator() {
        this.driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
    }

    @Override
    public Double combine(Double x, Double y) {
        String xx = convert(x);
        String yy = convert(y);
        calculation();
        this.setSearchBox(xx + "+" + yy);
        submit();
        return convertResultToDouble(getResultBox());
    }

    @Override
    public Double deduct(Double x, Double y) {
        String xx = convert(x);
        String yy = convert(y);
        calculation();
        this.setSearchBox(xx + "-" + yy);
        submit();
        return convertResultToDouble(getResultBox());
    }

    @Override
    public Double multiply(Double x, Double y) {
        String xx = convert(x);
        String yy = convert(y);
        calculation();
        this.setSearchBox(xx + "*" + yy);
        submit();
        return convertResultToDouble(getResultBox());
    }

    @Override
    public Double divide(Double x, Double y) {
        String xx = convert(x);
        String yy = convert(y);
        calculation();
        this.setSearchBox(xx + "/" + yy);
        submit();
        return convertResultToDouble(getResultBox());
    }

    @Override
    public void close() {
        if (driver != null)
            driver.quit();
    }

    private String getSearchBox() {
        WebElement element = driver.findElement(searchBox);
        return element.getText();
    }

    private void setSearchBox(String strSearch) {
        driver.findElement(searchBox).sendKeys(strSearch);
    }

    private String getResultBox() {
        WebElement element = driver.findElement(resultBox);
        return element.getText();
    }

    private void submit() {
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }

    private Double convertResultToDouble(String resultBox) {
        String result = resultBox;
        return Double.parseDouble(result);
    }

    private void clearSearchBox() {
        WebElement searchbox = driver.findElement(searchBox);
        searchbox.clear();
    }

    private String convert(Double number) {
        return number.toString();
    }

    private void calculation() {
        this.setSearchBox("Calculator");
        submit();
        this.clearSearchBox();
    }
}