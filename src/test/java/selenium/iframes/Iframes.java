package selenium.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.TestBase;

public class Iframes extends TestBase {

    @Test
    public void iframeShowCase() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        // driver.switchTo().frame("mce_0_ifr");// it took time
        WebElement idOfFrame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(idOfFrame);
        WebElement element = driver.findElement(By.xpath("//p"));
        element.clear();
        element.sendKeys("KOBE");

        driver.switchTo().parentFrame();

        WebElement element1 = driver.findElement(By.linkText("Elemental Selenium"));
        element1.click();

    }

    @Test
    public void nestedFrame() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement leftText = driver.findElement(By.xpath("//body[contains(.,'LEFT')]"));
        System.out.println(BrowserUtils.getText(leftText));

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        WebElement rightText = driver.findElement(By.xpath("//body[contains(.,'RIGHT')]"));
        System.out.println(BrowserUtils.getText(rightText));


        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        WebElement middleText = driver.findElement(By.xpath("//body[contains(.,'MIDDLE')]"));
        System.out.println(BrowserUtils.getText(middleText));

        driver.switchTo().defaultContent();

//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-bottom");

        WebElement bottomText = driver.findElement(By.xpath("//body[contains(.,'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottomText));
    }

    @Test
    public void iframeTask1() {
        driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");
        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='iFrame1']"));
        driver.switchTo().frame(iframe1);
        WebElement textBox = driver.findElement(By.xpath("//div[@class='rsw-ce']"));
        textBox.clear();
        textBox.sendKeys("Hello World");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("iFrame2");

        WebElement responsiveTesting = driver.findElement(By.xpath("//p[.='Responsive Testing']"));

        BrowserUtils.scroller(driver, responsiveTesting);
//        BrowserUtils.scrollWithJS(driver, responsiveTesting);
//        BrowserUtils.scrollWithPointJS(driver, responsiveTesting);

        responsiveTesting.click();
    }
}
