package selenium.xpath_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathPractice {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void practice() throws InterruptedException {
        driver.get("https://phptravels.com/demo/");
        WebElement firstName = driver.findElement(By.xpath("//input[@class='first_name form-control']"));
        firstName.sendKeys("Thomas");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='last_name']"));
        lastName.sendKeys("Shelby");

        WebElement shelbyBrotherLtd = driver.findElement(By.xpath("//input[@name='business_name']"));
        shelbyBrotherLtd.sendKeys("Shelby Brothers Limited");

        WebElement email = driver.findElement(By.xpath("//input[@class='email form-control']"));
        email.sendKeys("shelby@brothers.com");

        WebElement num1 = driver.findElement(By.xpath("//span[@id='numb1']"));

        WebElement num2 = driver.findElement(By.xpath("//span[@id='numb2']"));


        String stringNumber1 = num1.getText();
        String stringNumber2 = num2.getText();


        Integer number1 = Integer.parseInt(stringNumber1);
        Integer number2 = Integer.parseInt(stringNumber2);

        Integer answer = number1 + number2;
        String realAnswer = String.valueOf(answer);


        WebElement resultBox = driver.findElement(By.xpath("//input[@id='number']"));
        resultBox.sendKeys(realAnswer);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@id='demo']")).click();








    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
