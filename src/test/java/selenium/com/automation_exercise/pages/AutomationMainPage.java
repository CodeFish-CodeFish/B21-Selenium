package selenium.com.automation_exercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationMainPage {

    public AutomationMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(.,'Contact us')]")
    WebElement contactUsLink;

    public void clickOnContactUs(){
        this.contactUsLink.click();
    }






}
