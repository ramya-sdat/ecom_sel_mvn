package com.rnedesigns.ui.bdd;

import com.rnedesigns.ui.bdd.driver.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    private DriverFactory driverFactory = new DriverFactory();

    @Before
    public void setUp() {
        driverFactory.openBrowser();
        driverFactory.enterAppUrl();
        driverFactory.maximizeWindow();
        driverFactory.implicitWait();
        driverFactory.clickOnPopUp();
    }

    @After
    public void closeBrowser() {
        driverFactory.quitBrowser();
    }

}
