package cucumber.options;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
	features="src/test/java/features",
			glue="stepDefinitions"
)
public class TestRunner extends AbstractTestNGCucumberTests{

}
