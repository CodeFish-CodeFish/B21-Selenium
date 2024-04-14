package selenium.com.lambda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LambdaMainPage {

    public LambdaMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='Ajax Form Submit']")
    WebElement ajaxLink;

    public void clickOnAjaxLink(){
        this.ajaxLink.click();
    }





}
