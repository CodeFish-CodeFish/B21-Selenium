package selenium.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        driver = DriverHelper.getDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
//         ITestResult result <-- this Interface needs to be passed into tearDown method parameters
//        if (!result.isSuccess()){ // uncomment this 'if' condition if needed
//            BrowserUtils.takeScreenshot(driver);
//        }

        driver.quit();
    }

}
