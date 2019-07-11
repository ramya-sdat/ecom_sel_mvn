package com.rnedesigns.ui.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                    features = "src/test/features",
                    plugin = {"json:target/cucumber.json", "junit:target/cucumber.xml", "html:target/cucumberHtmlReport"}
                )
public class RunnerCukesTest {}
