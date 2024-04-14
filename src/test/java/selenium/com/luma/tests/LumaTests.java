package selenium.com.luma.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.com.luma.pages.LumaLoginPage;
import selenium.com.luma.pages.LumaMainPage;
import selenium.utils.TestBase;

public class LumaTests extends TestBase {

    @DataProvider(name = "testData")
    public Object[][] getData() {

        return new Object[][]{

                {"test@test.com", "fasdfds"},
                {"dsads@gmail.com", "43214343"},
                {"  ", "rfdgsdfgfd"},
                {"adsa@test.com", " "},

        };

    }


    @Test(dataProvider = "testData")
    public void luma_tc_02(String email, String password) {

        driver.get("https://magento.softwaretestingboard.com/");

        LumaMainPage lumaMainPage = new LumaMainPage(driver);
        lumaMainPage.clickOnSignIn();

        LumaLoginPage loginPage = new LumaLoginPage(driver);
        String expectedErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        loginPage.validateSignInFunctionality(email, password, expectedErrorMessage);

        String errorMessage = loginPage.errorMessageLogin();
        System.out.println(errorMessage);


    }
}
