package strangecalculator.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleCalculatorWithPureJS implements CalculatorInterface {
    private WebDriver driver;
    private JavascriptExecutor js;
    private By result = By.id("cwos");
    private String javaScript = "var evObj = document.createEvent('MouseEvents');" +
            "evObj.initMouseEvent('mouseup', true, true, window, 0, 0, 0, 0, 0, false, false, true, false, 0, null);" +
            "arguments[0].dispatchEvent(evObj);";

    public GoogleCalculatorWithPureJS() {
        this.driver = new ChromeDriver();
        driver.navigate().to("https://www.google.pl/search?q=google+calculator&rlz=1C1PDZP_ruPL721PL721&oq=google+" +
                "calculator&aqs=chrome.0.69i59j69i60l2j0l3.4359j0j7&sourceid=chrome&ie=UTF-8");
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
    }

    @Override
    public Double combine(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        clickOnNumber(xStr);
        js.executeScript(javaScript, driver.findElement(By.xpath("//div/span[text()='+']")));
        clickOnNumber(yStr);
        return getResult();
    }

    @Override
    public Double deduct(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        clickOnNumber(xStr);
        js.executeScript(javaScript, driver.findElement(By.xpath("//div/span[text()='−']")));
        clickOnNumber(yStr);
        return getResult();
    }

    @Override
    public Double multiply(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        clickOnNumber(xStr);
        js.executeScript(javaScript, driver.findElement(By.xpath("//div/span[text()='×']")));
        clickOnNumber(yStr);
        return getResult();
    }

    @Override
    public Double divide(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        clickOnNumber(xStr);
        js.executeScript(javaScript, driver.findElement(By.xpath("//div/span[text()='÷']")));
        clickOnNumber(yStr);
        return getResult();
    }

    @Override
    public void close() {
        if (driver != null)
            driver.quit();
    }

    private void clickOnNumber(String number) {
        String[] arrayStr = number.split("");
        waitABit();
        for (int i = 0; i < arrayStr.length; i++) {
            if (arrayStr[i].equals(".")) {
                js.executeScript(javaScript, driver.findElement(By.xpath("//div/span[text()='.']")));
            } else if (arrayStr[i].equals("-")) {
                js.executeScript(javaScript, driver.findElement(By.xpath("//div/span[text()='−']")));
            } else {
                js.executeScript(javaScript, driver.
                        findElement(By.xpath(String.format("//div/span[@class='cwbts' and text()='%s']", arrayStr[i]))));
            }
        }
    }

    private String convert(Double number) {
        return number.toString();
    }

    private Double getResult() {
        js.executeScript(javaScript, driver.findElement(By.xpath("//div/span[text()='=']")));
        WebElement element = driver.findElement(result);
        String result = element.getText();
        return Double.parseDouble(result);
    }

    private void waitABit() {
        for (int i = 0; i < 400; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }
}
