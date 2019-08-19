package com.rnedesigns.ui.bdd.stepsDefinitions;

import com.rnedesigns.ui.bdd.pageObjects.ResultsPage;
import cucumber.api.java.en.Then;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class FilterStepDefs {
    ResultsPage resultsPage = new ResultsPage();

    @Then("^I will choose the option \"([^\"]*)\"$")
    public void i_will_choose_the_option(String choice) {
        resultsPage.selectACustomersRating(choice);
    }

    @Then("^then I should get list as per selected Customers Rating$")
    public void then_I_should_get_list_as_per_selected_Customers_Rating() {
        List<Double> actualRatingsList = resultsPage.getListOfProductsAsPerSelectedCustomersRating();
        assertThat(actualRatingsList, Matchers.everyItem(Matchers.greaterThanOrEqualTo(4.0)));
    }

}
