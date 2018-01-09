package strangecalculator.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorWithIframe implements CalculatorInterface{
    private WebDriver driver;
    private JavascriptExecutor js;

    public CalculatorWithIframe(){
        driver = new ChromeDriver();
        js = (JavascriptExecutor)driver;
        driver.navigate().to("http://calculator-1.com/widgets/");
        js.executeScript("window.scrollBy(0,300)", "") ;
        driver.switchTo().frame("frcalcul");
    }
    @Override
    public Double combine(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        clickOnNumber(xStr);
        driver.findElement(By.cssSelector("td#bt_pl")).click();
        clickOnNumber(yStr);
        driver.findElement(By.cssSelector("td#bt_rv")).click();
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
        driver.findElement(By.cssSelector("td#bt_mi")).click();
        clickOnNumber(yStr);
        driver.findElement(By.cssSelector("td#bt_rv")).click();
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
        driver.findElement(By.cssSelector("td#bt_um")).click();
        clickOnNumber(yStr);
        driver.findElement(By.cssSelector("td#bt_rv")).click();
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
        driver.findElement(By.cssSelector("td#bt_dl")).click();
        clickOnNumber(yStr);
        driver.findElement(By.cssSelector("td#bt_rv")).click();
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

    private void clickOnNumber(String number) {
        String[] arrayStr = number.split("");
        WebElement element;
        for (int i = 0; i < arrayStr.length; i++) {
            if (arrayStr[i].equals(".")) {
                element = driver.findElement(By.cssSelector("td#bt_zp"));
                element.click();
            } else if (arrayStr[i].equals("-")) {
                element = driver.findElement(By.cssSelector("td#bt_mi"));
                element.click();
            } else {

                element = driver.findElement(By.cssSelector(String.format("td#bt_%s", arrayStr[i])));
                element.click();
            }
        }
    }

    private String convert(Double number) {
        return number.toString();
    }

    private Double getResult() {
        WebElement element = driver.findElement(By.cssSelector("input.displ-out"));
        String result = element.getAttribute("value");
        return Double.parseDouble(result);
    }
}
