package strangecalculator.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalculatorPi implements CalculatorInterface {
    WebDriver driver;

    public void setup() {

        driver = new ChromeDriver();

        driver.navigate().to("https://calculatorpi.com/");
        Actions builder = new Actions(driver);
        WebElement inputBox = driver.findElement(By.cssSelector("button.btn_num"));
        builder.moveToElement(inputBox).build().perform();
        inputBox.click();

        System.out.println(inputBox.getText());

        //   String elem = driver.findElement(By.xpath(String.format("button[id^='Btn%s)]",1))).getText();
        //#Btn1  //button[text()='1']
        //   driver.findElement(By.cssSelector(String.format("#Btn%s",4))).click();
        // System.out.println(elem);
        // driver.findElement(By.xpath(String.format("//button[text()=%s]","."))).click();
        // driver.findElement(By.xpath(String.format("//button[contains(text(), %s)]", "-"))).click();
        //By.xpath(String.format("//span[@class='cwbts' and contains(text(), %s)]", yy)));
    }

    @Override
    public Double combine(Double x, Double y) {
        return null;
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
}
