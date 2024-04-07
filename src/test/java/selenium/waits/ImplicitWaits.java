package selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.TestBase;

public class ImplicitWaits extends TestBase {

    @Test
    public void implicitWaitShowCase(){

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();

        WebElement text = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        System.out.println(BrowserUtils.getText(text));

    }
}
