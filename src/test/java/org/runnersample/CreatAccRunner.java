package org.runnersample;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "org.step",
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-report.html"
        }
)

public class CreatAccRunner {
}