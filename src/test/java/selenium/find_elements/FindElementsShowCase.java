package selenium.find_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FindElementsShowCase {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementsPractice() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));

        List<String> dataFromWebPage = new ArrayList<>();

        for (int i = 1; i < allLinks.size(); i++) {
            dataFromWebPage.add(allLinks.get(i).getText());
        }
        System.out.println(dataFromWebPage);

//        List<String> test = new ArrayList<>();
//        test.get(0).charAt(0);

        List<String> shortTexts = new ArrayList<>();
        for (int i = 1; i < allLinks.size(); i++) {

            if (allLinks.get(i).getText().length() < 8) {
                shortTexts.add(allLinks.get(i).getText());
            }


        }
        System.out.println("shortTexts = " + shortTexts);


        // Loop through your webElements and if your webElement contains 'Hovers' then click on it
        for (int i = 1; i < allLinks.size(); i++) {

            Thread.sleep(400);
            if (allLinks.get(i).getText().equalsIgnoreCase("Hovers")){
                allLinks.get(i).click();
                break;
            }

        }

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
