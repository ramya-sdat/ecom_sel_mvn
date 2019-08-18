package com.rnedesigns.ui.bdd.stepsDefinitions;

import com.rnedesigns.ui.bdd.pageObjects.HomePage;
import com.rnedesigns.ui.bdd.pageObjects.ResultsPage;
import com.rnedesigns.ui.bdd.utils.ExplicitWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchStepDefs {

    private HomePage homePage = new HomePage();
    private ResultsPage resultsPage = new ResultsPage();
    private ExplicitWait explicitWait = new ExplicitWait();

    @Given("^I am on home page$")
    public void i_am_on_home_page() {
        String actualUrl = homePage.getHomePageUrl();
        assertThat("Home page doesn't match..", actualUrl, Matchers.endsWith("co.uk/"));
    }

    @When("^I search for a product puma$")
    public void i_search_for_a_product_puma() {
        homePage.doSearch("puma");
    }

    @Then("^I should be able to view respective list of product$")
    public void i_should_be_able_to_view_respective_list_of_product() {
        String actual = resultsPage.getSearchedProductHeader();
        explicitWait.explicitlyWait(3000);
        assertThat("Some other product has returned", actual, Matchers.is(Matchers.equalToIgnoringCase(HomePage.searchedProductTitle)));
    }

    @When("^I search for a product \"([^\"]*)\"$")
    public void iSearchForAProduct(String item) {
        homePage.doSearch(item);
        explicitWait.explicitlyWait(3000);
    }

    @When("^I search for the product \"([^\"]*)\"$")
    public void iSearchForTheProduct(String particularProd) {
        homePage.doSearch(particularProd);
        explicitWait.explicitlyWait(3000);
    }

    @Then("^I should be able to view list of bag pack$")
    public void iShouldBeAbleToViewListOfBagPack() {
        String actual = resultsPage.getSearchedProductHeader();
        assertThat(actual, Matchers.is(Matchers.not(HomePage.searchedProductTitle)));
    }
}
