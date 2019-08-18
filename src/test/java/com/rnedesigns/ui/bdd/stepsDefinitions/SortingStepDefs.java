package com.rnedesigns.ui.bdd.stepsDefinitions;

import com.google.common.collect.Ordering;
import com.rnedesigns.ui.bdd.pageObjects.ResultsPage;
import cucumber.api.java.en.And;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class SortingStepDefs {
    ResultsPage resultsPage = new ResultsPage();

    @And("^click dropdown to choose \"([^\"]*)\"$")
    public void clickDropdownToChoose(String option) {
        resultsPage.chooseDropdownOptionFromList(option);
        List<Double> listOfLowToHighPrices = resultsPage.getPricesOfSortedFromLowToHigh();
        boolean sorted = Ordering.natural().isOrdered(listOfLowToHighPrices);
        assertThat("Price has not sorted", sorted, Matchers.is(Matchers.equalTo(true)));
    }
}
