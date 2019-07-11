package com.rnedesigns.ui.bdd.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    protected static WebDriver driver;

    private String browser = "chrome";
    private String appUrl = "https://www.argos.co.uk";

//    private String browser = "browser";
//    private String appUrl = "appUrl";

    public DriverFactory() {
        PageFactory.initElements(driver, this);
    }

    private void browserChoice() {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default:
                driver = new FirefoxDriver();
        }
    }

    public void openBrowser() {
        browserChoice();
    }

    public void enterAppUrl() {
        driver.get(appUrl);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }

    public void clickOnPopUp() {
        driver.findElement(By.linkText("GOT IT")).click();
    }

    public void quitBrowser() {
        driver.quit();
    }

}
