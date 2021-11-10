package cucumber.options;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features", 
		glue = "stepDefinitions", 
		monochrome = true, 
		plugin = {
		"json:target/cucumber-reports/cucumber.json", "pretty", "html:target/html-report/cucumber-html-reports.html",
		"junit:target/cucumber-reports/cucumber.xml" }, 
		dryRun = false)
public class TestRunner extends AbstractTestNGCucumberTests {

}
