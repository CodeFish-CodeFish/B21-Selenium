package selenium.select_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DropDown {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void handleDropDown() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dropdown")).click();

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");

    }

    @Test
    public void lambdaDropdown() {
         /*
       Please verify that dropdown is working as expected on dropdown page
       1. Navigate to main page and click 'Select Dropdown List' link
       2. On 'Select Dropdown List' page choose 'Saturday' option from the dropdown
        */


        driver.get("https://www.lambdatest.com/selenium-playground/");
        //select[@id='select-demo'] dropdown xpath
        driver.findElement(By.xpath("//a[.='Select Dropdown List']")).click();

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='select-demo']"));

        Select select = new Select(dropdown);
        // select.selectByVisibleText("Saturday");
//        select.selectByValue("Friday");


        WebElement firstSelectedOption = select.getFirstSelectedOption();
        String str = firstSelectedOption.getText();
        System.out.println(str);
        select.selectByIndex(6);

        List<WebElement> optionsFromDropdown = select.getOptions();

        for (int i = 0; i < optionsFromDropdown.size(); i++) {

            if (optionsFromDropdown.get(i).getText().equalsIgnoreCase("tuesday")) {
                optionsFromDropdown.get(i).click();
            }

        }


    }

    @Test
    public void task1() throws InterruptedException {
        /*
        1. Navigate to main page of lamda
        2. Click on Input Form Submit
        3. Fill in all the input fields including dropdown for country
        4. Click submit at the end
         */

        driver.get("https://www.lambdatest.com/selenium-playground/");
        WebElement inputSubmitForm = driver.findElement(By.linkText("Input Form Submit"));
        inputSubmitForm.click();

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Kobe");

        WebElement email = driver.findElement(By.id("inputEmail4"));
        email.sendKeys("test@test.com");

        WebElement password = driver.findElement(By.id("inputPassword4"));
        password.sendKeys("testPassword");

        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("IBM");

        WebElement website = driver.findElement(By.xpath("//input[@id='websitename']"));
        website.sendKeys("www.ibm.com");

        WebElement countryDropdown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countryDropdown);
        select.selectByValue("GB");

        //New Zealand
        Thread.sleep(3000);
        WebElement city = driver.findElement(By.xpath("//input[@id='inputCity']"));
        city.sendKeys("Chitown");

        WebElement address1 = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address1.sendKeys("test st");

        WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys("test st 2");

        WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
        state.sendKeys("Illinois");

        WebElement zip = driver.findElement(By.xpath("//input[@id='inputZip']"));
        zip.sendKeys("60656");

        WebElement submitBtn = driver.findElement(By.xpath("//button[.='Submit']"));
        submitBtn.click();


    }

    @Test
    public void task2() {
        driver.get("https://www.lambdatest.com/selenium-playground/");
        /*
        1. Navigate to lambda web page
        2. Click on Table Pagination
        3. Select 'Show All Rows'
        4. Store firstName and email in Map as key=value
        5. Print that Map, close your driver

        store data in Map interface
        ex:
        Key=value
        firstName=email
        Roland=r.lloyd@randatmail.com
         */

        driver.findElement(By.xpath("//a[.='Table Pagination']")).click();

        WebElement dropdown = driver.findElement(By.id("maxRows"));
        Select select = new Select(dropdown);
        select.selectByIndex(0);

        List<WebElement> firstNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> emails = driver.findElements(By.xpath("//tr//td[4]"));

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < firstNames.size(); i++) {

//            String name = firstNames.get(i).getText(); // getting each firstName and storing in a temp string
//            String email = emails.get(i).getText(); // getting each email and storing in a temp string
//
//            map.put(name, email);

            map.put(firstNames.get(i).getText(), emails.get(i).getText());

        }

        System.out.println(map);

        /*
        Create another Map and store lastName and phone numbers as key=value
        ex:
          key=value
        Lloyd=428-0863-03
         */

        List<WebElement> lastNames = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> phoneNumbers = driver.findElements(By.xpath("//tr//td[5]"));


        Map<String, String> info = new HashMap<>();

        for (int i = 0; i < lastNames.size(); i++) {

            info.put(lastNames.get(i).getText(),phoneNumbers.get(i).getText());

        }
        System.out.println(info);




    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
