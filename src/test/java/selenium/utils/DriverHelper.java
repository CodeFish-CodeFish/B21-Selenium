package selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverHelper {

    // Singleton Pattern Design
    // Centralizing our driver into this class. Driver will be coming only from this class


    //Example of encapsulation
    private static WebDriver driver; // private variable

    //Example of encapsulation
    private DriverHelper(){} // private constructor - the main reason for making
                            // the constructor private is that we do not need to create object from this class


    // if you performing parrallel test
    public static WebDriver getDriver(){
        // Will check if there are any active drivers
        if (driver == null || ((RemoteWebDriver)driver).getSessionId()==null){

            switch (ConfigReader.readProperty("browser")){

                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                case "safari":
                    driver = new SafariDriver();
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                default:
                    driver = new ChromeDriver();

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }

        return driver;

    }

}
