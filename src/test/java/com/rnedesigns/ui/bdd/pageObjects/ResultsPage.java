package com.rnedesigns.ui.bdd.pageObjects;

import com.rnedesigns.ui.bdd.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends DriverFactory {

    @FindBy(css = ".search-title__term")
    WebElement h1_titleHeader;

    @FindBy(css = ".sort-select")
    WebElement select_dropdownList;

    @FindBy(css = ".ac-product-price__amount")
    List<WebElement> span_productPrice;

    // For Filter by Customer Rating:
    @FindBy(css = ".ac-facet__filters--rating .ac-facet__label--rating")
    List<WebElement> ul_listOfCustomersRating;

    // For web element with ratings star:
    @FindBy(css = ".Ratingsstyles__Stars-sc-8mrsjy-2")
    List<WebElement> div_CustomersRated;

    public String getSearchedProductHeader() {
        return h1_titleHeader.getText();
//        return driver.findElement(By.cssSelector(".search-title__term")).getText();

    }

    public void chooseDropdownOptionFromList(String opt) {
        Select selectFromDropdown = new Select(select_dropdownList);
        selectFromDropdown.selectByVisibleText(opt);
    }

    //Method for assertion of Low to High price list:
    public List<Double> getPricesOfSortedFromLowToHigh() {
        List<Double> lowToHighPricesList = new ArrayList<>();
        List<WebElement> lowToHighWebElements = span_productPrice;
        for (WebElement lowToHighWebEle : lowToHighWebElements) {
            String priceInString = lowToHighWebEle.getText().replace("£", "");
            double priceInDouble = Double.parseDouble(priceInString);
            lowToHighPricesList.add(priceInDouble);
        }
        return lowToHighPricesList;
    }

    //Fetching product upon selected Customer Rating:
    public void selectACustomersRating(String choice) {
        for (WebElement ratingsListWebElement : ul_listOfCustomersRating) {
            if (ratingsListWebElement.getText().equalsIgnoreCase(choice)) {
                ratingsListWebElement.click();
            break;
            }
        }
    }

    //For Asserting the products list when selected via Customers Rating:
    public List<Double> getListOfProductsAsPerSelectedCustomersRating() {
        List<Double> collectedRatings = new ArrayList<>();
        for (WebElement ratingsWebElement : div_CustomersRated) {
            String ratingValueInString = ratingsWebElement.getAttribute("data-star-rating");
            double ratingValueInDouble = Double.parseDouble(ratingValueInString);
            collectedRatings.add(ratingValueInDouble);
        }
        return collectedRatings;
    }

}
