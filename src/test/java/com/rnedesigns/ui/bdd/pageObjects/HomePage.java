package com.rnedesigns.ui.bdd.pageObjects;

import com.rnedesigns.ui.bdd.driver.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverFactory {

    public static String searchedProductTitle;

    @FindBy(id = "searchTerm")
//    public WebElement searchTxtBox;
    WebElement input_searchTxtBox;

    @FindBy(css = "button._2mKaC")
    private WebElement searchButton;

    public void doSearch(String item) {
        input_searchTxtBox.sendKeys(item);
        searchButton.click();

        searchedProductTitle = item;
    }

    public String getHomePageUrl() {
        return driver.getCurrentUrl();
    }

}
