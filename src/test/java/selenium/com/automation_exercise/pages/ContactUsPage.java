package selenium.com.automation_exercise.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.utils.BrowserUtils;

public class ContactUsPage {

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "name")
    WebElement name;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(css = "input[name='subject']")
    WebElement subject;

    @FindBy(id = "message")
    WebElement message;

    @FindBy(name = "upload_file")
    WebElement attachFile;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    WebElement submit;

    public void fillOutForm(WebDriver driver, String name, String email, String subject, String message, String path){

        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.subject.sendKeys(subject);
        this.message.sendKeys(message);
        this.attachFile.sendKeys(path);
        this.submit.click();

        String textAlert = BrowserUtils.getTextAlert(driver);
        String expectedAlertText = "Press OK to proceed!";

        Assert.assertEquals(expectedAlertText, textAlert); // validation of text on alert pop up

        BrowserUtils.acceptAlert(driver);





    }





}
