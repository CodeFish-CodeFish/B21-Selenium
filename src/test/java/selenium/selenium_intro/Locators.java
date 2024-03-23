package selenium.selenium_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Locators {

    /*
    What is locator?

    Locators are used to locate web elements in the web page

    Selenium provides us couple locators --> ID, ClassName, TagName, Name, LinkText and PartialLinkText

    APjFqb

     */

    @Test
    public void locatorPractice() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        WebElement searchBar = driver.findElement(By.id("APjFqb")); // it is a search bar
        searchBar.sendKeys("iPhone 15 Pro", Keys.ENTER);

        // basic locators in Selenium.
//
//        driver.findElement(By.tagName("textarea"));;
//        driver.findElement(By.className("gLFyf"));
//
//        driver.findElement(By.linkText(""));
//        driver.findElement(By.partialLinkText(""));
//
//        driver.findElement(By.name(""));
//        driver.findElement(By.id(""));

        driver.navigate().to("https://codefish.io/");
        WebElement programs = driver.findElement(By.className("program-menu"));
        programs.click();

        WebElement text = driver.findElement(By.tagName("h1"));

        String actualText = text.getText();
        System.out.println(actualText);

        driver.get("https://www.google.com/");

        WebElement nameLocator = driver.findElement(By.name("q"));
        nameLocator.sendKeys("Breaking Bad", Keys.ENTER);

        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement linkText = driver.findElement(By.linkText("A/B Testing"));
        linkText.click();

        driver.navigate().back();

        WebElement partialLinkTest = driver.findElement(By.partialLinkText("Basic"));
        partialLinkTest.click();

        /*
        SELENIUM LOCATORS:

            id
            tagName
            name
            className
            linkText
            partialLinkText

         */
    }


    @Test
    public void task1(){

        /*
        AC:
        Please navigate to webpage we just created together
        Fill in all the information
        Click submit
        And quit your driver
         */


        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/codefish/Desktop/B21-HTML/inputFields.html");
        driver.manage().window().maximize();

        WebElement fname = driver.findElement(By.id("fname"));
        fname.sendKeys("Thomas");


        /*
        Task - sendKeys into last name input field.
        First find its locator either under id or name
        Then sendKeys("");

         */

        WebElement lastName = driver.findElement(By.name("lname"));
        lastName.sendKeys("Shelby");

        /*
        Next Task:

        Finish up filling out input fields skip Payment Methods dropdown
        Click Submit at the end
         */


        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("23885274635874587");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("test@test.com");

        WebElement telephone = driver.findElement(By.name("cell"));
        telephone.sendKeys("3123232323");

        WebElement datePicker = driver.findElement(By.id("bdate"));
        datePicker.sendKeys("12/31/2023");

        WebElement quantity = driver.findElement(By.name("quantity"));
        quantity.sendKeys("99");

        WebElement doctor = driver.findElement(By.id("Dr."));
        doctor.click();

        WebElement checkBox = driver.findElement(By.name("checkbox"));
        checkBox.click();

        WebElement textArea = driver.findElement(By.tagName("textarea"));
        textArea.sendKeys("Please reply by 25th of May");




    }
}
