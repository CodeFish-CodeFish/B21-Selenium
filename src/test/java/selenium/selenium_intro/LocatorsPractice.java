package selenium.selenium_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorsPractice {

    /*
    AC:

        Launch browser
        navigate to "https://www.godaddy.com/"
        Validate title with if condition
        Validate url with if condition
        Quit you driver.

     */

    // DRY - Do not Repeat Yourself
    WebDriver driver;

    @BeforeMethod
    public void initializeDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Driver initialized");
    }

    @Test
    public void TC_01() throws InterruptedException {

        driver.get("https://www.godaddy.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";// Dev, BA, PO, PM

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title pass");
        }else {
            System.out.println("Title failed");
        }

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.godaddy.com/";

        if (actualURL.equals(expectedURL)){
            System.out.println("URL matches -- pass");
        }else {
            System.out.println("URL did not match -- failed");
        }

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void TC_02(){

        /*
        Navigate to "https://the-internet.herokuapp.com/"
        Click on inputs link with LinkText
        SendKeys into the input field using tagName
        Click on Elemental Selenium with partialLinkText
        driver.quit at the end
         */
        driver.get("https://the-internet.herokuapp.com/");
        WebElement inputs = driver.findElement(By.linkText("Inputs"));
        inputs.click();

        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("100");

        WebElement elemental = driver.findElement(By.partialLinkText("Elemental"));
        elemental.click();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        System.out.println("Driver closed");
        Thread.sleep(2000);
        driver.quit();
    }

}
