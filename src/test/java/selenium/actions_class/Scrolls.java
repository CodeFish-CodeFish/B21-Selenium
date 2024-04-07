package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import selenium.utils.TestBase;

public class Scrolls extends TestBase {

    @Test
    public void scrollPageShowCase() throws InterruptedException {

        // We will scroll down the page
        driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        //actions.scrollByAmount(0, 3000).build().perform();// scrolling the page by deltaY 3000

        WebElement flashingImage = driver.findElement(By.xpath("//div[@class='ml-15 mt-15 h-265']//img"));
        actions.scrollToElement(flashingImage).build().perform(); //
        Thread.sleep(2000);
        actions.moveToElement(flashingImage).build().perform();// hovers over an image

        // actions.moveByOffset() used with clickAndHold -->

        WebElement textOnTop = driver.findElement(By.xpath("//h2[.='CSS Hover Effects on Button']"));
       // actions.scrollToElement(textOnTop).build().perform();
        actions.scrollByAmount(0, -3000).build().perform();

    }

}
