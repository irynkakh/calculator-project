import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleCalculator implements CalculatorInterface {
    private String url = "https://www.google.com";

    public void getUrlOfSite(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement search = driver.findElement(By.id("lst-ib"));
        search.sendKeys("Calculator");
        search.sendKeys(Keys.ENTER);


        WebElement operation = driver.findElement(By.id("cwtlbb"));

        Actions action = new Actions(driver);
        action.moveToElement(operation).build().perform();
        action.click();
        action.perform();

        WebElement ele = driver.findElement(By.className("cwtlotc"));
        ele.sendKeys("1+1");
        ele.sendKeys(Keys.ENTER);

        // WebElement op = driver.findElement(By.className("cwtlb cwtlbh"));
        //  op.click();

        // WebElement op2= driver.findElement(By.className("cwtlb cwtlbh cwtlbs"));
        //   op2.click();
        //  WebElement op2 = driver.findElement(By.className("cwtlotc"));
        //action.sendKeys("1+1");
        //action.sendKeys(Keys.ENTER);

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
