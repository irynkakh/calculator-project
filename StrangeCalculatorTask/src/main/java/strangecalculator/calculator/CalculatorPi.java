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
        this.driver = new ChromeDriver();
        driver.navigate().to("https://calculatorpi.com/");
        WebElement element = driver.findElement(By.xpath("button.btn_num"));
        builder.click(element).build().perform();
    }

    @Override
    public Double combine(Double x, Double y) {
        String xx = convert(x);
        String yy = convert(y);
       /* calculation();
        this.setSearchBox(xx + "+" + yy);
        submit();
        return convertResultToDouble(getResultBox());*/
        return null;
    }

    private String convert(Double number) {
        return number.toString();
    }

    private void clickOnNumber(String number) {

        String[] arrayStr = number.split("");
        WebElement element;

        for (int i = 0; i < arrayStr.length; i++) {


                element = driver.findElement(By.cssSelector(String.format("//button[@id='Btn%s']", arrayStr[i])));
                element.click();
            }
        }


    @Override
    public Double deduct(Double x, Double y) {
        return null;
    }

    @Override
    public Double multiply(Double x, Double y) {
        return null;
    }

    @Override
    public Double divide(Double x, Double y) {
        return null;
    }

    @Override
    public void close() {

    }
}
