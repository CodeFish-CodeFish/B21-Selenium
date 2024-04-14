package selenium.com.lambda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjaxDemoPage {

    public AjaxDemoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "title")
    WebElement nameField;

    @FindBy(id = "description")
    WebElement messageField;

    @FindBy(id = "btn-submit")
    WebElement button;

    public void fillInBlanks(String name, String message){
        this.nameField.sendKeys(name);
        this.messageField.sendKeys(message);
        this.button.click();
    }


}
