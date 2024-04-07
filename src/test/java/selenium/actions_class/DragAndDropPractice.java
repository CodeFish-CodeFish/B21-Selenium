package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.utils.TestBase;
import selenium.utils.BrowserUtils;

public class DragAndDropPractice extends TestBase {


    @Test
    public void dragAndDropShowCase() {


        driver.get("https://demoqa.com/droppable");

        Actions actions = new Actions(driver);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement dropArea = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));

        //actions.dragAndDrop(draggable, dropArea).perform();
        actions.clickAndHold(draggable).moveToElement(dropArea).release().perform();


        WebElement droppedText = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//p"));

        String actualText = BrowserUtils.getText(droppedText);
        String expectedText = "Dropped!";

        // Validation with Assertion
        Assert.assertEquals(actualText, expectedText, "Failed to validate text from dropBox");


    }

    @Test
    public void dragAndDropTask1() throws InterruptedException {

        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement draggable1 = driver.findElement(By.xpath("//span[.='Draggable 1']"));
        WebElement draggable2 = driver.findElement(By.xpath("//span[.='Draggable 2']"));
        WebElement dropArea = driver.findElement(By.id("mydropzone"));
        BrowserUtils.clickHoldDrop(driver, draggable1, dropArea);
        BrowserUtils.clickHoldDrop(driver, draggable2, dropArea);
        WebElement droppedListText = driver.findElement(By.id("droppedlist"));
        System.out.println(BrowserUtils.getText(droppedListText));
        Thread.sleep(3000);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        BrowserUtils.dragAndDrop(driver, draggable, droppable);
        //refresh, reassignment.
        droppable = driver.findElement(By.id("droppable")); // avoiding staleElementReferenceException
        String backgroundColor = droppable.getCssValue("color"); // it could give me stale
        System.out.println(backgroundColor);



    }

    @Test
    public void dragAndDropWithOffSet(){
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveByOffset(0, -500).release().build().perform();


//        actions.moveByOffset(0, 500).click().perform();
    }

    @Test
    public void dragSliderAction() {

        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(slider).moveByOffset(0, 50).perform();

    }


}
