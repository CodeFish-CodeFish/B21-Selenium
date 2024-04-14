package selenium.com.sauce_labs.tests;

import org.testng.annotations.Test;
import selenium.com.sauce_labs.pages.SauceLoginPage;
import selenium.com.sauce_labs.pages.SauceMainPage;
import selenium.utils.ConfigReader;
import selenium.utils.TestBase;

public class SauceLabTests extends TestBase {

    @Test
    public void sauceLasDropdowns() {

        driver.get("https://www.saucedemo.com/");

        // login
        SauceLoginPage loginPage = new SauceLoginPage(driver);
        loginPage.loginSauceLab(ConfigReader.readProperty("SLUsername"), ConfigReader.readProperty("SLPassword"));

        //dropdown handle
        SauceMainPage mainPage = new SauceMainPage(driver);
        String option = "Price (high to low)";
        mainPage.handleDropdown(option);


    }
}
