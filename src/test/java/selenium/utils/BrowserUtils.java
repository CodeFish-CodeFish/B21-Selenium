package selenium.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class BrowserUtils {

    public static void selectBy(WebElement location, String value, String methodName) {

        Select select = new Select(location);

        switch (methodName) {

            case "visibleText":
                select.selectByVisibleText(value);
                break;

            case "value":
                select.selectByValue(value);
                break;

            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;

            default:
                System.out.println("The option you chose is not available. Please use index, value or visibleText");


        }

    }

    //Return text from WebElement
    public static String getText(WebElement element) {
        return element.getText().trim();
    }


    //re-usable method to accepting alert
    public static void acceptAlert(WebDriver driver) {

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    // re-usable method to dismiss alert
    public static void dismissAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public static String getTextAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public static void sendKeysAlert(WebDriver driver, String textToBeSent){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(textToBeSent);
    }

    public static void switchWindowsById(WebDriver driver){

        String mainID = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String id : windowHandles){
            if (!id.equals(mainID)){
                driver.switchTo().window(id);
                break;
            }
        }


    }

    public static void switchWindowByTitle(WebDriver driver, String title){


        Set<String> windowHandles = driver.getWindowHandles();
        for (String id:windowHandles){
            driver.switchTo().window(id);
            if (driver.getTitle().endsWith(title)){
                break;
            }
        }

    }




}
