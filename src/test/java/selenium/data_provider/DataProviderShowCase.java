package selenium.data_provider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderShowCase {


    /*
    DataProvider - it is another way of keeping test data
     */

    @DataProvider(name = "myData")
    public Object[][]getData(){
        return new Object[][] {
                {"Roman", "Enayet"},
                {"John", "Wick"},
                {"Thomas", "Shelby"},
                {"Thomas", "Shelby"},
                {"Thomas", "Shelby"},
                {"Thomas", "Shelby"},
                {"Thomas", "Shelby"},
                {"Thomas", "Shelby"},
                {"Thomas", "Shelby"},
                {"Thomas", "Shelby"}
        };
    }


    @Test(dataProvider = "myData")
    public void testDataProvider(String first, String second){

        System.out.println(first + " " + second);

    }


}
