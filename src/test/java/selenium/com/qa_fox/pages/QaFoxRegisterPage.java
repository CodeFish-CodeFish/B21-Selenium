package selenium.com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QaFoxRegisterPage {

    public QaFoxRegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-firstname")
    WebElement firstname;

    @FindBy(id = "input-lastname")
    WebElement lastname;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-telephone")
    WebElement telephone;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(id = "input-confirm")
    WebElement passwordConfirm;

    @FindBy(css = "input[class='btn btn-primary']")
    WebElement continueBtn;

    public void createAccount(String firstname, String lastname, String email, String telephone, String password, String passwordConfirm){

        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.email.sendKeys(email);
        this.telephone.sendKeys(telephone);
        this.password.sendKeys(password);
        this.passwordConfirm.sendKeys(passwordConfirm);
        this.continueBtn.click();

    }




}
