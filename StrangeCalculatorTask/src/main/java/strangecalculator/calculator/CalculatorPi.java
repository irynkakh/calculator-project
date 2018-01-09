package strangecalculator.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CalculatorPi implements CalculatorInterface {
    private WebDriver driver;
    private Actions builder;
    private Action action;

    public CalculatorPi() {
        driver = new ChromeDriver();
        driver.navigate().to("https://calculatorpi.com/");
        builder = new Actions(driver);
    }

    @Override
    public Double combine(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        clickOnNumber(xStr);
        driver.findElement(By.xpath("//button[text()='+']")).click();
        clickOnNumber(yStr);
        driver.findElement(By.name("submit")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getResult();
    }

    @Override
    public Double deduct(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        clickOnNumber(xStr);
        driver.findElement(By.xpath("//button[text()='−']")).click();
        clickOnNumber(yStr);
        driver.findElement(By.name("submit")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getResult();
    }

    @Override
    public Double multiply(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        clickOnNumber(xStr);
        driver.findElement(By.xpath("//button[text()='×']")).click();
        clickOnNumber(yStr);
        driver.findElement(By.name("submit")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getResult();
    }

    @Override
    public Double divide(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        clickOnNumber(xStr);
        driver.findElement(By.xpath("//button[text()='∕']")).click();
        clickOnNumber(yStr);
        driver.findElement(By.name("submit")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    private void clickOnNumber(String number) {

        String[] arrayStr = number.split("");
        WebElement element;

        for (int i = 0; i < arrayStr.length; i++) {
            if (arrayStr[i].equals(".")) {
                element = driver.findElement(By.xpath("//button[text()='•']"));
                buildAndPerform(element);
            } else if (arrayStr[i].equals("-")) {
                element = driver.findElement(By.xpath("//button[text()='−']"));
                buildAndPerform(element);
            } else {

                element = driver.findElement(By.xpath(String.format("//button[text()='%s']", arrayStr[i])));
                buildAndPerform(element);
            }
        }
    }

    private void buildAndPerform(WebElement element) {
        builder.click(element);
        action = builder.build();
        action.perform();
    }

    private Double getResult() {
        WebElement element = driver.findElement(By.xpath("(//a)[15]"));
        String result = element.getText();
        return Double.parseDouble(result);
    }
}
