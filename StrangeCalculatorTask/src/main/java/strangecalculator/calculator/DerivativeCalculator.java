package strangecalculator.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DerivativeCalculator implements CalculatorInterface{
    private WebDriver driver;
    private WebDriverWait wait;
    private By expressionBox = By.id("expression");
    private By clearButton = By.id("clear-expression-button");
    private By calculateButton = By.id("go");
    private By result = By.xpath("*//div[@class='calc-math user-input-latex']//span[contains(@class,'mjx-math')]");
    private String calculation;

    public DerivativeCalculator() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 1000);
        driver.navigate().to("https://www.derivative-calculator.net/");
    }

    @Override
    public Double combine(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        String expression = xStr + '+' + yStr;
        calculate(expression);
        return getResult();
    }

    @Override
    public Double deduct(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        String expression = xStr + '-' + yStr;
        calculate(expression);
        return getResult();
    }

    @Override
    public Double multiply(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        String expression = xStr + '*' + yStr;
        calculate(expression);
        return getResult();
    }

    @Override
    public Double divide(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        String expression = xStr + '/' + yStr;
        calculate(expression);
        return getResult();
    }

    public void close() {
        if (driver != null)
            driver.quit();
    }

    private Double getResult() {
        WebElement element = driver.findElement(result);
        calculation = element.getText().replaceAll("\\n", "");
        return  toDouble(calculation);
    }

    private void calculate(String expression) {
        driver.findElement(clearButton).click();
        driver.findElement(expressionBox).sendKeys(expression);
        driver.findElement(calculateButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading-icon")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-icon")));
    }

    private String convert(Double number) {
        return number.toString();
    }

    private Double toDouble(String result) {
        if (result.charAt(0)=='−')
            result = result.replaceAll("−", "-");
       return (Double.parseDouble(result));
    }

}
