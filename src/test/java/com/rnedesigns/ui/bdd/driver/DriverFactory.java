package com.rnedesigns.ui.bdd.driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    protected static WebDriver driver;

//    private String browser = "chrome";
//    private String appUrl = "https://www.argos.co.uk";

    private String browser = System.getProperty("browser");
    private String appUrl = System.getProperty("appUrl");

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

//    public void embedScreenshot(Scenario scenario) {
//        try {
//            byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenShot, "image/png");
//        } catch (WebDriverException wbe) {
////            System.out.println("screenshot");
//            wbe.printStackTrace();
//        }
//    }

    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                wde.printStackTrace();
            }
        } else {
            try {
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            } catch (WebDriverException wde) {
                wde.printStackTrace();
            }
        }
    }

}
