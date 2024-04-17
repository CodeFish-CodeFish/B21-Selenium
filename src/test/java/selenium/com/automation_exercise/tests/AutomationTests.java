package selenium.com.automation_exercise.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selenium.com.automation_exercise.pages.AutomationMainPage;
import selenium.com.automation_exercise.pages.ContactUsPage;
import selenium.utils.TestBase;


public class AutomationTests extends TestBase {

    @Parameters({"name", "email", "subject", "message"})

    @Test
    public void AT_TC_02(String name, String email, String subject, String message){

        driver.get("https://www.automationexercise.com/");
        AutomationMainPage mainPage = new AutomationMainPage(driver);
        mainPage.clickOnContactUs();
        String fileLocation = "/Users/codefish/Desktop/B21-HTML/pb.jpg";
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillOutForm(driver,name,email, subject, message, fileLocation);


    }
}
