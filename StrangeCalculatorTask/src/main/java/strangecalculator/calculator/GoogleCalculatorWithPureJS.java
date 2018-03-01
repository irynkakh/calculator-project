package strangecalculator.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleCalculatorWithPureJS implements CalculatorInterface {
    private WebDriver driver;
    private JavascriptExecutor js;



    public GoogleCalculatorWithPureJS() {
        this.driver = new ChromeDriver();
        driver.navigate().to("https://www.google.pl/search?q=google+calculator&rlz=1C1PDZP_ruPL721PL721&oq=google+calculator&aqs=chrome.0.69i59j69i60l2j0l3.4359j0j7&sourceid=chrome&ie=UTF-8");

        WebElement number1 =  driver.findElement(By.xpath(String.format("//div//span[text()='1']", 1)));

        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent('mouseup', true, true, window, 0, 0, 0, 0, 0, false, false, true, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";

        ((JavascriptExecutor)driver).executeScript(javaScript, number1);
    }

    @Override
    public Double combine(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        clickOnNumber(xStr);
        driver.findElement(By.xpath("//div/span[text()='+']")).click();
        clickOnNumber(yStr);
        driver.findElement(By.xpath("//div/span[text()='=']")).click();
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

    public void clickOnNumber(String number) {

        String[] arrayStr = number.split("");
        WebElement element;
        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent('mouseup', true, true, window, 0, 0, 0, 0, 0, false, false, true, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        js = (JavascriptExecutor) driver;


        for (int i = 0; i < arrayStr.length; i++) {
            if (arrayStr[i].equals(".")) {
                element = driver.findElement(By.xpath("//div/span[text()='.']"));
                js.executeScript(javaScript, element);
            } else if (arrayStr[i].equals("-")) {
                element = driver.findElement(By.xpath("//div/span[text()='−']"));
                js.executeScript(javaScript, element);
            } else {

                element = driver.findElement(By.xpath(String.format("//div/span[text()='%s']", arrayStr[i])));
                js.executeScript(javaScript, element);
            }
        }
    }


    private Double getResult() {
        WebElement element = driver.findElement(By.id("cwos"));
        String result = element.getText();
        System.out.println(result);
        return Double.parseDouble(result);
    }
}
