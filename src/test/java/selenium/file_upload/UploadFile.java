package selenium.file_upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.ConfigReader;
import selenium.utils.DriverHelper;

import java.time.Duration;

public class UploadFile {

    @Test
    public void uploadAFile() {


        WebDriver driver = new ChromeDriver();
        driver.get(ConfigReader.readProperty("heroKaupURL"));
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
    public void task1() {

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

    @Test
    public void task2() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
        Launch your browser
        Navigate to url
        Fill out firstName, lastName, choose your gender, years of experience 7,
        Today's date, Automation tester, Selenium WebDriver, Continents - North America
        Selenium WebElement commands, attach a file, close the driver.
         */


        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys("Kobe");
        WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys("Abdy");

        WebElement gender = driver.findElement(By.id("sex-0"));
        gender.click();

        WebElement yearsOfExp = driver.findElement(By.id("exp-6"));
        yearsOfExp.click();

        Thread.sleep(4000);
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("03/09/2024");

        WebElement automationTester = driver.findElement(By.id("profession-1"));
        automationTester.click();

        WebElement seleniumWD = driver.findElement(By.id("tool-2"));
        seleniumWD.click();

        WebElement continents = driver.findElement(By.xpath("//select[@id='continents']"));

//        Select continentDropdown = new Select(continents);
//        continentDropdown.selectByVisibleText("North America");

        BrowserUtils.selectBy(continents, "North America", "visibleText");


        WebElement seleniumCommands = driver.findElement(By.xpath("//select[@id='selenium_commands']"));
        BrowserUtils.selectBy(seleniumCommands, "WebElement Commands","visibleText");


        WebElement fileUpload = driver.findElement(By.xpath("//input[@id='photo']"));
        fileUpload.sendKeys("/Users/codefish/Desktop/B21-HTML/pb.jpg");


    }

}
