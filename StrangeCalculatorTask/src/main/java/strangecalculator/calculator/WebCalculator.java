package strangecalculator.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebCalculator implements CalculatorInterface {

    WebDriver driver;

    public WebCalculator() {
        this.driver = driver;
    }

    public void setup() {
        driver = new ChromeDriver();
        driver.navigate().to("http://web2.0calc.com/");
    }

    private String convert(Double number) {

        return number.toString();
    }

    @Override
    public Double combine(Double x, Double y) {
        String xStr = convert(x);
        String yStr = convert(y);
        setup();
        clickOnNumber(xStr);
        driver.findElement(By.xpath("//button[@id='BtnPlus']")).click();
        clickOnNumber(yStr);
        driver.findElement(By.xpath("//button[@id='BtnCalc']")).click();
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
        setup();
        clickOnNumber(xStr);
        driver.findElement(By.xpath("//button[@id='BtnMinus']")).click();
        clickOnNumber(yStr);
        driver.findElement(By.xpath("//button[@id='BtnCalc']")).click();
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
        setup();
        clickOnNumber(xStr);
        driver.findElement(By.xpath("//button[@id='BtnMult']")).click();
        clickOnNumber(yStr);
        driver.findElement(By.xpath("//button[@id='BtnCalc']")).click();
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
        setup();
        clickOnNumber(xStr);
        driver.findElement(By.xpath("//button[@id='BtnDiv']")).click();
        clickOnNumber(yStr);
        driver.findElement(By.xpath("//button[@id='BtnCalc']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getResult();
    }

    private void clickOnNumber(String number) {

        String[] arrayStr = number.split("");
        WebElement element;

        for (int i = 0; i < arrayStr.length; i++) {
            if (arrayStr[i].equals(".")) {
                element = driver.findElement(By.xpath("//button[@id='BtnDot']"));
                element.click();
            } else if (arrayStr[i].equals("-")) {
                element = driver.findElement(By.xpath("//button[@id='BtnMinus']"));
                element.click();
            } else {

                element = driver.findElement(By.xpath(String.format("//button[@id='Btn%s']", arrayStr[i])));
                element.click();
            }
        }

    }

    private Double getResult() {
        WebElement element = driver.findElement(By.xpath("//input[@id='input']"));
        String result = element.getAttribute("value");
        return Double.parseDouble(result);
    }
}