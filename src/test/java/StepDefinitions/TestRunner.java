package StepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Features", 
	glue = { "StepDefinitions" },
	monochrome = true, plugin = {
		"pretty", 
		"html:target/HtmlReports" })

public class TestRunner extends AbstractTestNGCucumberTests {

}