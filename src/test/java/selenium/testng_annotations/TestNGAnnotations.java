package selenium.testng_annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Hello, this is me BeforeMethod");
    }

    @Test
    public void test1(){
        System.out.println("Hello, this is me TestAnnotation 1");
    }

    @Test
    public void test2(){
        System.out.println("Hello, this is me TestAnnotation 2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Hello, this is me AfterMethod");
    }

}
