package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import selenium.utils.TestBase;
import selenium.utils.BrowserUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoverOver extends TestBase {


    @Test
    public void hoverOverPractice() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> allUserImg = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<WebElement> allUserName = driver.findElements(By.xpath("//h5")); // empty list
        List<String> name = new ArrayList<>(); // empty list of string to store names

        Actions actions = new Actions(driver);

        for (int i = 0; i < allUserImg.size(); i++) {

            Thread.sleep(400);

            WebElement element = allUserImg.get(i);
            actions.moveToElement(element).perform();
            //        vs
            // actions.moveToElement(allUserImg.get(i)).perform();


            WebElement element1 = allUserName.get(i);
            String singleName = element1.getText();
            name.add(singleName);
            //      vs
           // name.add(allUserName.get(i).getText());

        }
        System.out.println(name);

    }

    @Test
    public void hoverOverTask() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='product k-listview-item']"));
        List<WebElement> productNames = driver.findElements(By.xpath("//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='product-description']//p"));

        // outcome should be like this --> chai=$18.00, extra bonus, remove dollar sign
        // you would need empty Map, loop, and Actions class out of the loop
        // hint -> to add data into Map, we can use put method
        // break

        Map<String, Double> info = new HashMap<>();
       // Actions actions = new Actions(driver);
        for (int i = 0; i < images.size(); i++) {

            Thread.sleep(400);
            //actions.moveToElement(images.get(i)).perform();
            BrowserUtils.hoverOver(driver, images.get(i));
            String priceString = prices.get(i).getText().replace("$", "");

            Double singlePrice = Double.parseDouble(priceString);
            String singleProduct = productNames.get(i).getText();
            info.put(singleProduct, singlePrice);

           // info.put(productNames.get(i).getText(), Double.parseDouble(prices.get(i).getText().replace("$", "")));

        }
        System.out.println(info);




    }




}
