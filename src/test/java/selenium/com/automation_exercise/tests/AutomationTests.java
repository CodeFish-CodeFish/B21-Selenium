package selenium.com.automation_exercise.tests;

import org.testng.annotations.Test;
import selenium.com.automation_exercise.pages.AutomationMainPage;
import selenium.com.automation_exercise.pages.ContactUsPage;
import selenium.utils.TestBase;

public class AutomationTests extends TestBase {

    @Test
    public void AT_TC_02(){

        driver.get("https://www.automationexercise.com/");
        AutomationMainPage mainPage = new AutomationMainPage(driver);
        mainPage.clickOnContactUs();
        String fileLocation = "/Users/codefish/Desktop/B21-HTML/pb.jpg";
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillOutForm(driver,"Kobe", "test@test.com", "test subject", "Message body", fileLocation);


    }
}
