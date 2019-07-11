package com.rnedesigns.ui.bdd.pageObjects;

import com.rnedesigns.ui.bdd.driver.DriverFactory;
import org.openqa.selenium.By;

public class ResultsPage extends DriverFactory {

    public String getSearchedProductHeader() {
        return driver.findElement(By.cssSelector(".search-title__term")).getText();
    }

}
