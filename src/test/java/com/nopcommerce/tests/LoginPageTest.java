package com.nopcommerce.tests;

import com.nopcommerce.base.BaseTest;
import com.nopcommerce.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @BeforeClass
    public void loginPageSetup(){
        loginPage = homePage.goToLoginPage();
    }

    @Test(priority = 1)
    public void verifyLoginPageNameTest() throws InterruptedException {
        Thread.sleep(2000);
        String pageName = loginPage.getLoginPageName();
        System.out.println(pageName);
        Assert.assertEquals(pageName, Constants.LOGIN_PAGE_NAME,"Page name does not match.");
    }

    @Test(priority = 2)
    public void verifyLoginButtonStatusTest(){
        Assert.assertTrue(loginPage.verifyLoginButton(),"Login button is not available");
    }

    @Test(priority = 3)
    public void verifyRegisterButtonStatusTest(){
        Assert.assertTrue(loginPage.verifyRegisterButton(),"Register button is not available");
    }

    @Test(priority = 4)
    public void validateUserLoginTest(){
        loginPage.doLogin(prop.getProperty("id"),prop.getProperty("pass"));
        Assert.assertTrue(homePage.verifyMyAccountLink(),"Login failed, My account link cannot verified");
    }

    @Test(priority = 5)
    public void logoutTest() throws InterruptedException {
        homePage.doLogout();
        Assert.assertTrue(homePage.verifyLoginLink(),"Logout failed, login link cannot be verified");
    }
}
