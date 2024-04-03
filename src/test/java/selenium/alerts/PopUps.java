package selenium.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

import java.time.Duration;

public class PopUps {

    WebDriver driver;
    @BeforeMethod
    public void startUp(){
       driver = DriverHelper.getDriver();
    }

    @Test
    public void alertPractice(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlert.click();

        BrowserUtils.acceptAlert(driver);

//        Alert alert = driver.switchTo().alert(); // we are switching our driver into the popup/alert
//        alert.accept(); // driver clicks ok button on alert

        WebElement successMessage = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(successMessage.getText(), "You successfully clicked an alert", "Failed to validate alert text");


    }

    @Test
    public void alertPractice2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsConfirm.click();
        Thread.sleep(2000);
        BrowserUtils.dismissAlert(driver);
//        Alert alert = driver.switchTo().alert(); // we are switching our driver into the popup/alert
//        alert.dismiss(); // driver clicks cancel button on alert

        WebElement successMessage = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(successMessage.getText(), "You clicked: Cancel", "Failed to validate alert text");

        WebElement jsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();

        BrowserUtils.sendKeysAlert(driver,"CodeFish SDET Program");
        //alert.sendKeys("CodeFish SDET Program");
        String jsAlertText = BrowserUtils.getTextAlert(driver);
        System.out.println(jsAlertText);
        BrowserUtils.acceptAlert(driver);
        //alert.accept();
    }

    @Test
    public void task1() throws InterruptedException {
        driver.get("https://sweetalert.js.org/");

        WebElement preview1 = driver.findElement(By.xpath("//h5[contains(.,'Normal alert')]//..//button"));
        preview1.click();

//        Alert alert = driver.switchTo().alert(); //switching the driver into the popped up alert
//        System.out.println(alert.getText());//gets the text on alert popup
//        alert.accept(); // clicks ok
        System.out.println(BrowserUtils.getTextAlert(driver));
        BrowserUtils.acceptAlert(driver);


        Thread.sleep(2000);
        WebElement preview2 = driver.findElement(By.xpath("//h5[contains(.,'SweetAlert')]//..//button"));
        preview2.click();
        Thread.sleep(2000);
        WebElement okOnPreview2 = driver.findElement(By.xpath("//button[.='OK']"));
        okOnPreview2.click();

    }

    /*
    Create new test case for contact us page on automation exercise
    Fill out all the input fields, attach a file and click submit button
    When submit button is clicked, js alert will pop up, get the text of the js alert and click ok on that alert
     */


    @Test
    public void task2(){
        driver.get("https://www.automationexercise.com/contact_us");
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("Test Kobe");

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("test@test.io");

        WebElement subject = driver.findElement(By.xpath("//input[@name='subject']"));
        subject.sendKeys("Subject text goes here");

        WebElement messageBody = driver.findElement(By.xpath("//textarea[@id='message']"));
        messageBody.sendKeys("Message body text goes here");

        WebElement fileUpload = driver.findElement(By.xpath("//input[@name='upload_file']"));
        fileUpload.sendKeys("/Users/codefish/Desktop/B21-HTML/pb.jpg");

        WebElement submitBtn = driver.findElement(By.xpath("//input[@name='submit']"));
        submitBtn.click();

        Alert dr = driver.switchTo().alert();
        System.out.println(dr.getText());

        dr.accept();




    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
