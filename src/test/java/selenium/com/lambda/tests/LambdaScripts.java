package selenium.com.lambda.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selenium.com.lambda.pages.AjaxDemoPage;
import selenium.com.lambda.pages.LambdaMainPage;
import selenium.utils.TestBase;

public class LambdaScripts extends TestBase {

    @Parameters({"testName","testMessage"})
    @Test
    public void LB_TC_01(String testName, String testMessage){

        driver.get("https://www.lambdatest.com/selenium-playground/");

        LambdaMainPage mainPage = new LambdaMainPage(driver);
        mainPage.clickOnAjaxLink();

        // driver.findElement

        AjaxDemoPage demoPage = new AjaxDemoPage(driver);
        demoPage.fillInBlanks(testName, testMessage);

    }



}
