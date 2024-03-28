package selenium.select_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class SelectPractice {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void bookAFlight() throws InterruptedException {

        /*
        1. Navigate to flight finder, validate url and title of the page - done
        2. Click on 'One Way' radio button                               - donne
        3. Select 4 passengers                                           - done
        4. Departing from Zurich on December 31st                        - done
        5. Arriving in Seattle on January 31st                           - done
        6. Click first class radio button                                - done
        7. Select Unified Airlines
        8. Click on Continue button
        9. Validate the message at the end

        Extra bonus point:

            Try to get options for airlines and use if condition, if options
            has a record that matches unified airlines, choose that option with this condition
         */


        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        System.out.println(driver.getTitle().equals("Find a Flight: Mercury Tours: ")); //true/false

        System.out.println(driver.getCurrentUrl().equals("https://demo.guru99.com/test/newtours/reservation.php"));// true/false

        WebElement oneWayRadio = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayRadio.click();

        WebElement passenger = driver.findElement(By.xpath("//select[@name='passCount']"));

        Select passengerDropdown = new Select(passenger);
        passengerDropdown.selectByVisibleText("4");

        WebElement fromCity = driver.findElement(By.xpath("//select[@name='fromPort']"));

        Select departingCityDropdown = new Select(fromCity);
        departingCityDropdown.selectByValue("Zurich");

        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));

        Select fromMonthDropdown = new Select(fromMonth);
        fromMonthDropdown.selectByIndex(11);

        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));

        Select fromDayDropdown = new Select(fromDay);
        fromDayDropdown.selectByIndex(30);

        WebElement toCity = driver.findElement(By.xpath("//select[@name='toPort']"));

        Select toCityDropdown = new Select(toCity);
        toCityDropdown.selectByVisibleText("Seattle");

        WebElement returnMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));

        Select returnMonthDropdown = new Select(returnMonth);
        returnMonthDropdown.selectByIndex(0);

        WebElement returnDay = driver.findElement(By.xpath("//select[@name='toDay']"));

        Select returnDayDropdown = new Select(returnDay);
        returnDayDropdown.selectByValue("31");

        Thread.sleep(3000);
        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));

        Select airlineDropdown = new Select(airlines);

        List<WebElement> airlineDropdownOptions = airlineDropdown.getOptions();

        //Enhanced Loop
        //DataType tempName : Source
        for (WebElement airline : airlineDropdownOptions){

            if (airline.getText().equalsIgnoreCase("unified airlines")){
                airline.click();
            }

        }

        WebElement continueBtn = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueBtn.click();

        WebElement textMessage = driver.findElement(By.xpath("//font[contains(.,'After flight finder - No Seats Avaialble')]"));
        String actualText = textMessage.getText();
        System.out.println(actualText);


    }

    @Test
    public void reusableMethodSelectPractice() throws InterruptedException {

        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        System.out.println(driver.getTitle().equals("Find a Flight: Mercury Tours: ")); //true/false
        System.out.println(driver.getCurrentUrl().equals("https://demo.guru99.com/test/newtours/reservation.php"));// true/false
        WebElement oneWayRadio = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayRadio.click();
        WebElement passenger = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passenger, "4", "visibleText");
        WebElement fromCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
        BrowserUtils.selectBy(fromCity, "Zurich","value");
        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(fromMonth, "11","index");
        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(fromDay, "30","index");
        WebElement toCity = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(toCity, "Seattle", "visibleText");
        WebElement returnMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(returnMonth, "0","index");
        WebElement returnDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(returnDay, "31","value");
        Thread.sleep(3000);
        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineDropdown = new Select(airlines);
        List<WebElement> airlineDropdownOptions = airlineDropdown.getOptions();
        //Enhanced Loop
        //DataType tempName : Source
        for (WebElement airline : airlineDropdownOptions){
            if (airline.getText().equalsIgnoreCase("unified airlines")){
                airline.click();
            }
        }
        WebElement continueBtn = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueBtn.click();
        WebElement textMessage = driver.findElement(By.xpath("//font[contains(.,'After flight finder - No Seats Avaialble')]"));
        String actualText = BrowserUtils.getText(textMessage);
        System.out.println(actualText);


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }


}
