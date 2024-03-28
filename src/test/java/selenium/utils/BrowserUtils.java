package selenium.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserUtils {

    public static void selectBy(WebElement location, String value, String methodName){

        Select select = new Select(location);

        switch (methodName){

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

    public static String getText(WebElement element){
        return element.getText().trim();
    }



}
