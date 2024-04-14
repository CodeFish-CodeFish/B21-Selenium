package selenium.com.luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.utils.BrowserUtils;

public class LumaLoginPage {

    public LumaLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[id='email']")
    WebElement email;

    @FindBy(css = "input[title='Password']")
    WebElement password;

    @FindBy(xpath = "//button[@class='action login primary']")
    WebElement button;

    @FindBy(xpath = "//div[@data-ui-id='message-error']")
    WebElement errorMessage;

    public void validateSignInFunctionality(String email, String password, String errorMessage){

        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.button.click();

        Assert.assertEquals(BrowserUtils.getText(this.errorMessage), errorMessage); // we are validating error message here


    }

    public String errorMessageLogin(){ // not validating error message here, instead we are returning it a string
        return BrowserUtils.getText(this.errorMessage);
    }





}
