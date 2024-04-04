package selenium.multi_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandles {

    WebDriver driver;

    @BeforeMethod
    public void initialize() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void windowHandleShowCase() {

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.partialLinkText("Click")).click();

        String mainPageID = driver.getWindowHandle(); // returns main page unique id

        Set<String> allWindowId = driver.getWindowHandles(); // returns all unique id

        // This is good only for 2 window tabs
        for (String id : allWindowId) {

            if (!id.equals(mainPageID)) {
                driver.switchTo().window(id);
                break;
            }
        }

        System.out.println(driver.getTitle());


    }

    @Test
    public void task1() {
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.findElement(By.xpath("//button[contains(.,'Open New Tab')]")).click();

//        String mainID = driver.getWindowHandle();
//        Set<String> allIDs = driver.getWindowHandles();
//
//
//        for (String id : allIDs){
//
//            if (!id.equals(mainID)){
//                driver.switchTo().window(id);
//                break;
//            }
//
//        }
        BrowserUtils.switchWindowsById(driver);


        WebElement textFromDifferentTab = driver.findElement(By.xpath("//h1[contains(.,'AlertsDemo')]"));
        String header = BrowserUtils.getText(textFromDifferentTab);
        Assert.assertEquals("AlertsDemo", header);
        Assert.assertTrue(header.contains("AlertsDemo"));
        System.out.println(header);


    }

    @Test
    public void switchByTitleShowCase() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
        driver.findElement(By.partialLinkText("Twitter")).click();
        driver.findElement(By.partialLinkText("Facebook")).click();
        driver.findElement(By.partialLinkText("Linkedin")).click();

        // this will work on more than 2 windows situations
        String desiredTitle = "LambdaTest | San Francisco CA | Facebook";
        Set<String> windowHandles = driver.getWindowHandles();

        for (String id : windowHandles){

            driver.switchTo().window(id);
            Thread.sleep(400);
            if (driver.getTitle().equals(desiredTitle)){
                break;
            }

        }
        System.out.println(driver.getTitle());

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
