package strangecalculator.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalculatorPi implements CalculatorInterface {
    private WebDriver driver;
    private Actions builder;
    
    public CalculatorPi() {
        driver = new ChromeDriver();
        driver.navigate().to("https://calculatorpi.com/");
        builder = new Actions(driver);
    }

    @Override
    public Double combine(Double x, Double y) {
        clickOnNumber(x);
        WebElement plus = driver.findElement(By.xpath("//button[text()='+']"));
        builder.moveToElement(plus).click().build().perform();
        clickOnNumber(y);
        return getResult();
    }

    @Override
    public Double deduct(Double x, Double y) {
        clickOnNumber(x);
        WebElement minus = driver.findElement(By.xpath("//button[text()='−']"));
        builder.moveToElement(minus).click().build().perform();
        clickOnNumber(y);
        return getResult();
    }

    @Override
    public Double multiply(Double x, Double y) {
        clickOnNumber(x);
        WebElement star = driver.findElement(By.xpath("//button[text()='×']"));
        builder.moveToElement(star).click().build().perform();
        clickOnNumber(y);
        return getResult();
    }

    @Override
    public Double divide(Double x, Double y) {
        clickOnNumber(x);
        WebElement slash = driver.findElement(By.xpath("//button[text()='∕']"));
        builder.moveToElement(slash).click().build().perform();
        clickOnNumber(y);
        return getResult();
    }

    @Override
    public void close() {
        if (driver != null)
            driver.quit();
    }

    private String convert(Double number) {
        return number.toString();
    }

    private void clickOnNumber(Double x) {
        String number = convert(x);
        char[] arrayStr = number.toCharArray();
        WebElement element;
        for (char i : arrayStr) {
            if (i == '.') {
                element = driver.findElement(By.xpath("//button[text()='•']"));
                element.click();
            } else if (i == '-') {
                element = driver.findElement(By.xpath("//button[text()='−']"));
                element.click();
            } else {
                element = driver.findElement(By.xpath(String.format("//button[text()='%s']", i)));
                element.click();
            }
        }
    }

    private Double getResult() {
        driver.findElement(By.name("submit")).click();
        WebElement element = driver.findElement(By.xpath("(//a)[15]"));
        String result = element.getText();
        return Double.parseDouble(result);
    }
}
