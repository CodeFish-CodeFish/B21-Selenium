package selenium.com.luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LumaMainPage {

    /*

    Strictly follow Page Object Model:

    1. Create pages class
    2. Create test class where you will execute your automation tests
    3. Navigate to main page and click login link
    4. In login page, provide wrong credentials to sign in
    5. Validate error message is displayed
     */

    public LumaMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='#contentarea']//following-sibling::ul//a[contains(.,'Sign In')]")
    WebElement signInLink;

    public void clickOnSignIn(){
        this.signInLink.click();
    }


}
