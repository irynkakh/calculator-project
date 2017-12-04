package strangecalculator.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleCalculator implements CalculatorInterface {

    WebDriver driver;
    By searchBox = By.id("lst-ib");
    By resultBox = By.id("cwos");

    public GoogleCalculator() {
        this.driver = driver;
    }

    public WebElement getSearchBox() {

        return driver.findElement(searchBox);

    }

    public void setSearchBox(String strSearch) {

        driver.findElement(searchBox).sendKeys(strSearch);

    }

    public WebElement getResultBox() {

        return driver.findElement(resultBox);

    }

    public void submit(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    private Double convertResultToDouble(WebElement resultBox) {
        String result = resultBox.getText();

        return Double.parseDouble(result);
    }

    public void setup() {

        driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");

    }

    private void clearSearchBox() {
        WebElement searchbox = driver.findElement(searchBox);
        searchbox.clear();

    }

    private String convert(Double number) {

        return number.toString();
    }

    @Override
    public Double combine(Double x, Double y) {

        String xx = convert(x);
        String yy = convert(y);
        calculation();
        this.setSearchBox(xx + "+" + yy);
        submit(getSearchBox());

        return convertResultToDouble(getResultBox());
    }

    @Override
    public Double deduct(Double x, Double y) {

        String xx = convert(x);
        String yy = convert(y);
        calculation();
        this.setSearchBox(xx + "-" + yy);
        submit(getSearchBox());

        return convertResultToDouble(getResultBox());
    }

    @Override
    public Double multiply(Double x, Double y) {

        String xx = convert(x);
        String yy = convert(y);
        calculation();
        this.setSearchBox(xx + "*" + yy);
        submit(getSearchBox());

        return convertResultToDouble(getResultBox());
    }

    @Override
    public Double divide(Double x, Double y) {

        String xx = convert(x);
        String yy = convert(y);
        calculation();
        this.setSearchBox(xx + "/" + yy);
        submit(getSearchBox());

        return convertResultToDouble(getResultBox());

    }

    public void calculation() {

        setup();
        this.setSearchBox("Caclulator");
        submit(getSearchBox());
        this.clearSearchBox();

    }

}
