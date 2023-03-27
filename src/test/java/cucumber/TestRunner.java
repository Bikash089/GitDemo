package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber -> TestNG, Junit (Runner, to run feature files -- If using testNG assertion/runner then use TestNG or else use Junit)
@CucumberOptions(features="src/test/java/cucumber", glue="bikashautomationframework.stepDefinations",
monochrome=true, tags = "@Regression", plugin= {"html:target/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests{

	
}
