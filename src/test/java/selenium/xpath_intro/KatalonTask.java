package selenium.xpath_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KatalonTask {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() {

        // This is login functionality
        driver.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginBtn = driver.findElement(By.xpath("//button[.='Login']"));
        loginBtn.click();

        //Customer notes
        WebElement checkBox = driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
        checkBox.click();

        WebElement medicaid = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaid.click();

        WebElement datePicker = driver.findElement(By.xpath("//input[@name='visit_date']"));
        datePicker.sendKeys("31/12/2024");

        WebElement textArea = driver.findElement(By.xpath("//textarea[@name='comment']"));
        textArea.sendKeys("Please book 5 star hotel as well in Tokyo");

        WebElement bookAppointmentBtn = driver.findElement(By.xpath("//button[contains(text(),'Book Appointment')]"));
        bookAppointmentBtn.click();

        // Validate user's test data
        WebElement healthProgram = driver.findElement(By.xpath("//p[@id='program']"));
        System.out.println("healthProgram.isDisplayed() = " + healthProgram.isDisplayed());

        WebElement visitDate = driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println("visitDate.isDisplayed() = " + visitDate.isDisplayed());

        WebElement comment = driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println("comment.isDisplayed() = " + comment.isDisplayed());

        // click on go to home page button
        WebElement goToHomeBtn = driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        goToHomeBtn.click();

        // Validate main header in main page
        WebElement mainHeader = driver.findElement(By.xpath("//h1"));
        System.out.println("mainHeader.getText() = " + mainHeader.getText());


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
