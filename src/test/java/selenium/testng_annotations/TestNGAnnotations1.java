package selenium.testng_annotations;

import org.testng.annotations.*;

public class TestNGAnnotations1 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite Annotation");
        // depending on your needs for testing
        // we normally put here chromeDriver properties
        // ex deleting cookie before running our tests

    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest Annotation");
        //optional annotation
        // ex. we can use db connection before running our tests

    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass Annotation");
        // also used for common set up before our testing
        //this will engage before test method in the current class
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod Annotation");
        // we can initialize our driver here, or navigate to webPage, login etc
    }

    @Test(priority = 1)
    public void testAnnotation(){
        System.out.println("Test Annotation");
        // Here we perform our testing
    }

    @Test(priority = 2)
    public void anotherTest(){
        System.out.println("anotherTest");
        // Here we perform our testing
    }

    @Test(priority = 3)
    public void brother(){
        System.out.println("brother");
        // Here we perform our testing
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod Annotation");
        // we close/quite the driver, take screenshot etc.
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass Annotation");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest Annotation");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite Annotation");
    }





}
