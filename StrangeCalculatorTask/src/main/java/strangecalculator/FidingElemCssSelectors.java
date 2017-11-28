package strangecalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class FidingElemCssSelectors {

    private String url = "http://web2.0calc.com/";

    public void open(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        int dynamicLinkIndex = -1;
        // input[id^='combo-'][id$='-inputWrap'] [id$='09'] !!"button[id^='Btn']

        List<WebElement> numbers = driver.findElements(By.cssSelector("button[id^='Btn']"));
        int index = numbers.indexOf("1");
        System.out.println(index);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.contains("Btn1"));
            // WebElement one = numbers.get(i).findElement(By.cssSelector("#Btn1"));
            //one.click();
        }
        numbers.get(36).click();
        //  numbers.get(i).findElement(By.cssSelector("#Btn1"));







      /*  while(i.hasNext()) {
            WebElement row = i.next();
            System.out.println(row.getText());
        }*/
        List<String> nameofButton = new ArrayList<>();
        for (WebElement e : numbers) {
            //System.out.print("Text within the Anchor tab" + e.getText() + "\t"
            System.out.println(e.getText() + "->" + e.getAttribute("id"));
            nameofButton.add(e.getAttribute("id"));

        }
        System.out.println(nameofButton.indexOf("Btn1"));
    }


}
