package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/VendingMachine.feature",
        glue = {"StepDefinitions"},
        dryRun=false,
        monochrome=true,
        tags = "",
        plugin= {"pretty",
                "json:target/jsonReports/cucumber-reports.json","html:target/vending-machine-reports.html",
                "rerun:target/failedrerun.txt"
        }

)
public class TestRunner extends AbstractTestNGCucumberTests {

}
