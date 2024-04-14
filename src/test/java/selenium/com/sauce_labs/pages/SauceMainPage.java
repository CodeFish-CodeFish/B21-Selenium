package selenium.com.sauce_labs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import selenium.utils.BrowserUtils;

public class SauceMainPage {
    public SauceMainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    WebElement dropdown;

    public void handleDropdown(String option){

//        Select select = new Select(this.dropdown);
//        select.selectByVisibleText(option);

        BrowserUtils.selectBy(this.dropdown, option,"visibleText");

    }


}
