package selenium.file_upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class UploadFile {

    @Test
    public void uploadAFile(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement fileUpload = driver.findElement(By.xpath("//input[@id='file-upload']"));

        fileUpload.sendKeys("/Users/codefish/Downloads/breaking-bad1.webp");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//h3"));

        String actualMessage = successMessage.getText();
        String expectedMessage = "File Uploaded!";

        Assert.assertEquals(actualMessage, expectedMessage, "Failed to validate success message");// Validation with Assert.assertEquals
                                                            //Validation with assertion
                                                            // When it fails, we will see yellow color labelled message
                                                            // When it fails, it shows expected and actual values with optional message if entered before

       // Break



    }

    @Test
    public void task1(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
        Navigate to main page of automation exercise web page
        Click on Contact Us link
        Fill out the fields on Contact US page, attach a file and click on submit button
         */

        driver.findElement(By.xpath("//a[contains(.,' Contact us')]")).click();
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



    }

}
