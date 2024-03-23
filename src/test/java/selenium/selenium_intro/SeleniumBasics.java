package selenium.selenium_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumBasics {

    // Selenium WebDriver

    @Test // This is a Test annotation from TestNG framework
    public void TestCase_01(){

        WebDriver driver = new ChromeDriver(); // Polymorphism
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        String actualTitle = driver.getTitle(); // this is coming from webapp
        System.out.println(actualTitle);

        String expectedTitle = "Google";// this is provided by BA,PO, PM

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.google.com/";

        if (expectedURL.contains(actualURL)){
            System.out.println("URL was expected and displayed Pass");
        }else {
            System.out.println("URL was different -- Failed");
        }
    }

    @Test // This is a Test annotation
    public void TestCase_02(){
        WebDriver driver = new SafariDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        String actualPageSource = driver.getPageSource();
        System.out.println(actualPageSource);

    }

    @Test
    public void TestCase_03() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/"); // this method does not wait
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com/");
        Thread.sleep(3000);// not part of selenium, but it will pause the process for 3 seconds
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.quit();


    }



}
