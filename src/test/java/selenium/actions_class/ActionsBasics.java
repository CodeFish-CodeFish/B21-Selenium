package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import selenium.utils.BaseTest;
import selenium.utils.BrowserUtils;

// OOP concept Inheritance
public class ActionsBasics extends BaseTest{

    @Test
    public void contextClick(){

        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement rightClickArea = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(rightClickArea).perform();

        String textAlert = BrowserUtils.getTextAlert(driver);
        System.out.println(textAlert);

        BrowserUtils.acceptAlert(driver);




    }

    @Test
    public void rightClickAndDoubleClick() throws InterruptedException {

        /*
        Navigate to webpage, right click on 'Right Click me button' and click 'delete' option
        switch your driver to alert get its text and click ok
        double click on double click me button when alert is presented, switch your driver
        get text and click ok.

         */

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClick = driver.findElement(By.xpath("//span[contains(.,'right click me')]"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClick).perform();

        WebElement deleteOption = driver.findElement(By.xpath("//span[contains(.,'Delete')]"));
        actions.contextClick(deleteOption).perform();


        String textAlert = BrowserUtils.getTextAlert(driver);
        System.out.println(textAlert);
        Thread.sleep(2000);
        BrowserUtils.acceptAlert(driver);

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[.='Double-Click Me To See Alert']"));
        actions.doubleClick(doubleClickButton).perform();

        String textAlert1 = BrowserUtils.getTextAlert(driver);
        System.out.println(textAlert1);
        Thread.sleep(2000);
        BrowserUtils.acceptAlert(driver);




    }


}
