package selenium.java_script_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.utils.TestBase;

public class JSMethods extends TestBase {

    @Test
    public void getTitleWithJS() {

        driver.get("https://www.amazon.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String amazonTitle = js.executeScript("return document.title").toString();
        System.out.println("title of Amazon get with JavaScript method -> " + amazonTitle);
    }

    @Test
    public void clickWithJSMethod(){

        driver.get("https://codefish.io/");
        WebElement aboutUs = driver.findElement(By.xpath("//button[.='About us']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", aboutUs);
    }

    @Test
    public void scrollWithJSMethod(){

        driver.get("https://codefish.io/");
        WebElement faceBookLink = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/codefish.camp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", faceBookLink);
    }

    @Test
    public void scrollWithPointJSMethod(){

        driver.get("https://codefish.io/");
        WebElement faceBookLink = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/codefish.camp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point point = faceBookLink.getLocation(); // gets the location of the webElement

        int x = point.getX();// gets horizontal distance from edge of the screen to the webElement
        int y = point.getY();//gets vertical distance from edge of the screen to the webElement
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        js.executeScript("window.scrollTo(" + x + "," + y + ")");

    }

    @Test
    public void getURLWithJS(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://codefish.io/')");
        js.executeScript("window.open('https://www.amazon.com/')");
        js.executeScript("window.open('https://www.ebay.com/')");

    }



}
