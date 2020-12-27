package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/java/Features",glue="Steps",
        plugin = { "pretty",

                "html:target/cucumber/cucumber-html-report",

                "json:target/cucumber/cucumber-json-report.json"

        },dryRun = false, monochrome = true
        )
public class PlaidAndroidRunner {
}
