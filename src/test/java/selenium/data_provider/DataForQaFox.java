package selenium.data_provider;

import org.testng.annotations.DataProvider;

public class DataForQaFox {

    @DataProvider(name = "dataForQaFox")
    public Object[][]getData(){

        return new Object[][]{

                {"kuba", "abdy", "test@sdfdsf.com", "123456789", "QWEQWEWQE","QWEQWEWQE"},
                {"Roman", "lastname", "roma@test.com", "324134354", "FASDFSDGFDG","FASDFSDGFDG"},
                {"Enayet", "LASTNAME", "enayet@gm.com", "76876987978", "bxncvcnvxv","bxncvcnvxv"}

        };

    }
}
