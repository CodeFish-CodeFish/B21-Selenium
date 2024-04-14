package selenium.com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QaFoxMainPage {

    public QaFoxMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='My Account']")
    WebElement myAccountLink;

    @FindBy(xpath = "//a[.='Register']")
    WebElement registerLink;

    public void clickOnRegister(){

        this.myAccountLink.click();
        this.registerLink.click();

    }





}
