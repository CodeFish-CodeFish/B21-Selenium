package selenium.xpath_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LambdaTest {

    ////h4[.='Default value 5']//..//input

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void SlideIt(){

                                                                        // parent/child relationship in Xpath
        WebElement slider1 = driver.findElement((By.xpath("//h4[.='Default value 5']//..//input")));

        for (int i = 0; i < 10; i++) {
            slider1.sendKeys(Keys.ARROW_RIGHT);
        }

        List<WebElement> output = driver.findElements(By.xpath("//output")); // all the texts
        List<WebElement> sliders = driver.findElements(By.xpath("//input[@type='range']")); // all sliders

        for (int i = 0; i < output.size(); i++) {

            while (!output.get(i).getText().equalsIgnoreCase("95")){
                sliders.get(i).sendKeys(Keys.ARROW_RIGHT);
            }

        }
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
