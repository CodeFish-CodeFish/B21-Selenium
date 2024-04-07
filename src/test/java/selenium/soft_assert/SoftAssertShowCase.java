package selenium.soft_assert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertShowCase {

    public int sum(int x, int y){
        return x + y;
    }

    @Test
    public void test1(){

        // Assert == Hard Assert
        Assert.assertEquals(sum(1,2), 3);
        System.out.println("working fine");

        Assert.assertEquals(sum(1,2), 4); // code failed here
        System.out.println("ignored");

        Assert.assertEquals(sum(1,2), 3);
        System.out.println("ignored");

    }

    @Test
    public void test2(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(sum(1,2), 3);
        System.out.println("Working fine");

        softAssert.assertEquals(sum(1,2), 4);
        System.out.println("Supposed to fail, but will continue");

        softAssert.assertEquals(sum(1,2), 3);
        System.out.println("working fine");

        softAssert.assertAll("See below comparison failure message");


    }



}
