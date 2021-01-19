package com.nopcommerce.tests;

import com.nopcommerce.base.BaseTest;
import com.nopcommerce.utils.Constants;
import com.nopcommerce.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    @BeforeClass
    public void registerPageSetup(){
        registerPage = homePage.goToRegisterPage();
    }

    @Test(priority = 1)
    public void verifyRegisterPageNameTest() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(registerPage.getRegisterPageName(), Constants.REGISTER_PAGE_NAME);
    }

    @Test(priority = 2, dataProvider = "getUserData")
    public void registerNewUserTest(String gender, String fName, String lName, String day, String month, String year,
                                    String email,String company, String password) throws InterruptedException {
        registerPage.registerNewUser(gender,fName,lName,day,month,year,email,company,password);
        Thread.sleep(2000);
        homePage.doLogout();
        homePage.goToRegisterPage();
    }

    @DataProvider
    public Object[][] getUserData(){
        Object data[][] = ExcelUtil.getTestData(Constants.USER_SHEET_NAME);
        return data;
    }
}
