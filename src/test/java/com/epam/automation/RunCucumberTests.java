package com.epam.automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.epam.automation.driver",
                "com.epam.automation.steps"},
        plugin = {"json:target/cucumber-reports/Cucumber.json"},
        monochrome = true,
        tags = {"@smoke"}
)
public class RunCucumberTests {
}
