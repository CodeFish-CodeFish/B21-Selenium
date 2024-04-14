package selenium.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
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

    public static String getText(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText().trim();
    }


    //re-usable method to accepting alert
    public static void acceptAlert(WebDriver driver) {

//        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.alertIsPresent()).accept();

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

    public static void dragAndDrop(WebDriver driver, WebElement pickUp, WebElement dropOff){

        Actions actions = new Actions(driver);
        actions.dragAndDrop(pickUp, dropOff).build().perform();

    }
    public static void clickHoldDrop(WebDriver driver, WebElement pickUp, WebElement dropOff){

        Actions actions = new Actions(driver);
        actions.clickAndHold(pickUp).moveToElement(dropOff).release().build().perform();

    }

    public static void sendKeysWithActions(WebDriver driver,WebElement element, String keys){
        Actions actions = new Actions(driver);
        actions.sendKeys(element, keys).perform();
    }

    // method overloading --> example of polymorphism
    public static void clickWithActions(WebDriver driver, WebElement element){

        Actions actions = new Actions(driver);
        actions.click(element).build().perform();
    }

    public static void clickWithActions(WebDriver driver, int deltaX, int deltaY){
        Actions actions = new Actions(driver);
        actions.moveByOffset(deltaX, deltaY).click().build().perform();
    }

    public static void hoverOver(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public static void scroller(WebDriver driver, WebElement element){

        Actions actions = new Actions(driver);
        actions.scrollToElement(element).build().perform();

    }

    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();
    }

    public static void clickWithJS(WebDriver driver, WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public static void scrollWithJS(WebDriver driver, WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);

    }

    public static void scrollWithPointJS(WebDriver driver, WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point point = element.getLocation();
        int x = point.getX();
        int y = point.getY();

        js.executeScript("window.scrollTo(" + x + "," + y + ")");

    }

    public static void takeScreenshot(WebDriver driver){

        // Whenever you use this method please provide ITestResult interface in method parameters

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location = System.getProperty("user.dir") + "/src/main/screenshots/";

        File directory = new File(location);

        if (!directory.exists()){
            directory.mkdir();
        }

        try {
            FileUtils.copyFile(file, new File(location + System.currentTimeMillis() + ".png"));
        }catch (IOException e){

            throw new RuntimeException(e);

        }



    }














}
