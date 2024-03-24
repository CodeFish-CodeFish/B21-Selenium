package selenium.xpath_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XpathShowCase {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void xpathShowCase() {
        driver.get("https://www.google.com/");
        //tagName[@attribute='value']   --> Syntax
        //textarea[@id='APjFqb']        --> Real xpath

        WebElement searchBar = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBar.sendKeys("Jesse Pinkman", Keys.ENTER);
        driver.navigate().back();


//        WebElement microphone = driver.findElement(By.xpath("//div[@class='XDyW0e']"));
//        microphone.click();

        WebElement aboutLink = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
        aboutLink.click();

        driver.navigate().back();
        WebElement storeLink = driver.findElement(By.xpath("//a[.='Store']"));
        storeLink.click();

        driver.navigate().back();
        WebElement imagesLink = driver.findElement(By.xpath("//a[contains(.,'Images')]"));
        imagesLink.click();





    }

    @Test
    public void absoluteXpathAndRelativeXpath(){
        driver.get("https://the-internet.herokuapp.com");

        WebElement abTesting = driver.findElement(By.xpath("//a[.='A/B Testing']")); // Relative Xpath
        abTesting.click();

        WebElement paragraph = driver.findElement(By.xpath("/html/body/div/div/div/p")); //Absolute Xpath
        System.out.println(paragraph.getText());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
