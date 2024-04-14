package selenium.com.lambda.tests;

import org.testng.annotations.Test;
import selenium.com.lambda.pages.AjaxDemoPage;
import selenium.com.lambda.pages.LambdaMainPage;
import selenium.utils.TestBase;

public class LambdaScripts extends TestBase {

    @Test
    public void LB_TC_01(){

        driver.get("https://www.lambdatest.com/selenium-playground/");

        LambdaMainPage mainPage = new LambdaMainPage(driver);
        mainPage.clickOnAjaxLink();

        // driver.findElement

        AjaxDemoPage demoPage = new AjaxDemoPage(driver);
        demoPage.fillInBlanks("test", "message goes here");

    }



}
