package selenium.css_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.TestBase;

import java.util.List;

public class CSSLocators extends TestBase {

    @Test
    public void cssLocatorShowCase(){

        /*
        So we far we know locators as ID, Class, Name, TagName, LinkText, PartialLinkText

        And then we xpath. Xpath are divided into 2 sections:
        Absolute and Relative

        CSS Locators - easy syntax, faster process

        in xpath expression - //tagName[@attribute='value']
                             //div[@id='email']

        in CSS              - tagName[attribute='value']
                            - div[id='email']

                            #id
                            .class

         */

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.cssSelector("#input-firstname")); // id for css locator
        firstName.sendKeys("Test First Name");

        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));//xpath version of css locator
        lastName.sendKeys("Test Last Name");

        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        BrowserUtils.sendKeysWithActions(driver, email,"test@dsds.com");

        WebElement telephone = driver.findElement(By.cssSelector("input[id='input-telephone']"));
        telephone.sendKeys("342342343");

        WebElement password = driver.findElement(By.cssSelector("input[id='input-password']"));
        password.sendKeys("rewrewrewr");

        WebElement passwordConfirm = driver.findElement(By.cssSelector("input[id='input-confirm']"));
        passwordConfirm.sendKeys("rewrewrewr");

        List<WebElement> radioButtons = driver.findElements(By.cssSelector("label[class='radio-inline']"));

        for (int i = 0; i < radioButtons.size(); i++) {

            if (radioButtons.get(i).getText().equalsIgnoreCase("yes")){
                radioButtons.get(i).click();
            }

        }


    }


}
