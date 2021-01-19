package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By loginPageName = By.xpath("//div[@class='page-title']");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginBtn = By.xpath("//input[@value='Log in']");
    private By registerBtn =By.xpath("//input[@value='Register']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getLoginPageName(){
        elementUtil.waitForElementTobeVisible(loginPageName,2);
        //return driver.findElement(loginPageName).getText();
        return elementUtil.doGetText(loginPageName);
    }

    public boolean verifyLoginButton(){
        //return driver.findElement(loginBtn).isDisplayed();
        return elementUtil.doIsDisplayed(loginBtn);
    }

    public boolean verifyRegisterButton(){
        //return driver.findElement(registerBtn).isDisplayed();
        return elementUtil.doIsDisplayed(registerBtn);

    }

    public LoginPage doLogin(String username, String password){
        //driver.findElement(emailField).sendKeys(username);
        elementUtil.doSendKeys(emailField,username);
        //driver.findElement(passwordField).sendKeys(password);
        elementUtil.doSendKeys(passwordField,password);
        //driver.findElement(loginBtn).click();
        elementUtil.doClick(loginBtn);
        return new LoginPage(driver);
    }


}
