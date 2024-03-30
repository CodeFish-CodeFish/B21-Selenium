package selenium.get_attribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class GetAttributePractice {


    WebDriver driver;
    @BeforeMethod
    public void initializeDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01(){
        /*
        What is an attribute in the context of html?
            Anything after tagName and in front of value is called attribute.
            For example:
            <input type="text" target="_self" placeholder="name">
            in the example above, type, target, placeholder can be considered as attributes
            with their respective values

        What is getAttribute?

            So in Selenium, specifically in WebElement, we have a method called
            'getAttribute'. It refers to the key part and returns value
         */

        driver.get("https://www.automationexercise.com/contact_us");

        WebElement nameInput = driver.findElement(By.xpath("//input[@name='name']"));

        String placeHolderName = nameInput.getAttribute("placeholder");
        System.out.println(placeHolderName);

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));

        String emailAttribute = email.getAttribute("data-qa");
        System.out.println(emailAttribute);


        WebElement textArea = driver.findElement(By.xpath("//textarea[@id='message']"));
        String textAreaAttribute = textArea.getAttribute("placeholder");
        System.out.println(textAreaAttribute);


    }

    @Test
    public void task1(){
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");
        driver.findElement(By.xpath("//button")).click();

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@role='checkbox']"));

        WebElement firstElement = checkBoxes.get(0);
        String attribute = firstElement.getAttribute("aria-checked");
        System.out.println(attribute);

        for (int i = 0; i < checkBoxes.size(); i++) {

          if (checkBoxes.get(i).getAttribute("aria-checked").equalsIgnoreCase("false")){
              checkBoxes.get(i).click();
          }


        }


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(4000);
        driver.quit();
    }

}
