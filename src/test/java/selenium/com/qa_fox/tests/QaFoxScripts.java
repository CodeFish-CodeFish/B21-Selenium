package selenium.com.qa_fox.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.com.qa_fox.pages.QaFoxMainPage;
import selenium.com.qa_fox.pages.QaFoxRegisterPage;
import selenium.data_provider.DataForQaFox;
import selenium.utils.TestBase;

public class QaFoxScripts extends TestBase {

//    @DataProvider(name = "dataForQaFox")
//    public Object[][]getData(){
//
//        return new Object[][]{
//
//                {"kuba", "abdy", "test@sdfdsf.com", "123456789", "QWEQWEWQE","QWEQWEWQE"},
//                {"Roman", "lastname", "roma@test.com", "324134354", "FASDFSDGFDG","FASDFSDGFDG"},
//                {"Enayet", "LASTNAME", "enayet@gm.com", "76876987978", "bxncvcnvxv","bxncvcnvxv"}
//
//        };
//
//    }

    @Test(dataProvider = "dataForQaFox", dataProviderClass = DataForQaFox.class)
    public void TC_01_create_user_account(String firstname, String lastname, String email, String telephone,
                                          String password, String passwordConfirm){

        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
        QaFoxMainPage mainPage = new QaFoxMainPage(driver);
        mainPage.clickOnRegister();

        QaFoxRegisterPage registerPage = new QaFoxRegisterPage(driver);
        registerPage.createAccount(firstname, lastname, email, telephone, password, passwordConfirm);





    }



}
