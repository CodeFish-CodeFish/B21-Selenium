package selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import selenium.utils.TestBase;

import java.time.Duration;

public class FluentWaitsPractice extends TestBase {

    @Test
    public void fluentWaitShowCase(){


        // This is not working
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();

        //WebElement text = driver.findElement(By.xpath("//h4[.='Hello World!']"));

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(3))
                .withMessage("test")
                .withTimeout(Duration.ofSeconds(10));


        WebElement element = fluentWait.until(myDriver -> driver.findElement(By.xpath("//h4[.='Hello World!']")));
        System.out.println(element.getText());


    }

    @Test
    public void fluentWaitShowCase2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeBtn = driver.findElement(By.xpath("//button[.='Remove']"));
        removeBtn.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("text on page")
                .withTimeout(Duration.ofSeconds(10));


        WebElement element = fluentWait.until(myDriver -> driver.findElement(By.xpath("//p[@id='message']")));
        System.out.println(element.getText());


    }

    @Test
    public void fluentWaitShowCase3(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement button = driver.findElement(By.xpath("//button[.='Enable']"));
        button.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(ElementClickInterceptedException.class);

        WebElement inputField = driver.findElement(By.cssSelector("input[type='text']"));
        fluentWait.until(ExpectedConditions.elementToBeClickable(inputField)).sendKeys("test kobe test kobe");
    }

}
