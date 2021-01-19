package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.utils.Constants;
import com.nopcommerce.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    // locator

    private By searchPageName = By.xpath("//div[@class='page-title']/h1");
    private By searchPageSearchField = By.name("q");
    private By advancedSearchCheckBox = By.id("adv");
    private By catagoryDropdownList = By.id("cid");
    private By automaticallySearchCheckBox = By.id("isc");
    private By manufacturerDropDownList = By.id("mid");
    private By searchInProductCheckBox = By.id("sid");
    private By categoriesList = By.xpath("//div[@class='side-2']/div[1]/div[2]/descendant::a");
    private By manufacturesListXpath = By.xpath("//div[@class='side-2']/div[2]/div[2]/descendant::a");

    public String getSearchPageName(){
        return elementUtil.doGetText(searchPageName);
    }

    public boolean verifyManufactureDropdownList() throws InterruptedException {
        //elementUtil.waitForElementTobeVisible(advancedSearchCheckBox,10);
        Thread.sleep(2000);
        elementUtil.doClick(advancedSearchCheckBox);
        //elementUtil.waitForElementTobeVisible(advancedSearchCheckBox,10);
        Thread.sleep(2000);
        return elementUtil.compareDropdownOptions(manufacturerDropDownList, Constants.MANUFACTURE_DROPDOWN);
    }

    public List<String> getManufactureListItems(){
        List<String> manufacturesList = new ArrayList<String>();
        List<WebElement> manufactureListElements = elementUtil.getElements(manufacturesListXpath);
        for (WebElement e : manufactureListElements){
            manufacturesList.add(e.getText());
        }
        return manufacturesList;
    }
}
