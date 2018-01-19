package strangecalculator.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.NumberFormat;
import java.text.ParseException;

public class WebCalculator implements CalculatorInterface {
    private WebDriver driver;

    public WebCalculator() {
        this.driver = new ChromeDriver();
        driver.navigate().to("http://web2.0calc.com/");
    }

    @Override
    public Double combine(Double x, Double y) {
        clickOnNumber(x);
        driver.findElement(By.xpath("//button[@id='BtnPlus']")).click();
        clickOnNumber(y);
        return getResult();
    }


    @Override
    public Double deduct(Double x, Double y) {
        clickOnNumber(x);
        driver.findElement(By.xpath("//button[@id='BtnMinus']")).click();
        clickOnNumber(y);
        return getResult();
    }

    @Override
    public Double multiply(Double x, Double y) {
        clickOnNumber(x);
        driver.findElement(By.xpath("//button[@id='BtnMult']")).click();
        clickOnNumber(y);
        return getResult();
    }

    @Override
    public Double divide(Double x, Double y) {
        clickOnNumber(x);
        driver.findElement(By.xpath("//button[@id='BtnDiv']")).click();
        clickOnNumber(y);
        return getResult();
    }

    public void close() {
        if (driver != null)
            driver.quit();
    }

    private void clickOnNumber(Double x) {
        String number = convert(x);
        char[] arrayStr = number.toCharArray();
        WebElement element;
        for (char i : arrayStr){
            if (i == '.') {
                element = driver.findElement(By.xpath("//button[@id='BtnDot']"));
                element.click();
            } else if (i == '-') {
                element = driver.findElement(By.xpath("//button[@id='BtnMinus']"));
                element.click();
            } else {
                element = driver.findElement(By.xpath(String.format("//button[@id='Btn%s']", i)));
                element.click();
            }
        }
    }

    private Double getResult() {
        driver.findElement(By.xpath("//button[@id='BtnCalc']")).click();
        WebElement element = driver.findElement(By.xpath("//input[@id='input']"));
        String result = element.getAttribute("value");
        NumberFormat nf = NumberFormat.getInstance();
        Double number = null;
        try {
            number = nf.parse(result).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return number;
    }

    private String convert(Double number) {
        return number.toString();
    }
}