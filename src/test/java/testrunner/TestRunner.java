package testrunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.livesust.configuration.CucumberReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(features = { "src//test//resources//Features" }, 
	glue = {"stepdefinition"}, 
	plugin = {"json:target/cucumber.json"},
	tags = "@signin",
	monochrome = true, 
	dryRun = false)


	public class TestRunner {
		
		@BeforeClass
		 public static void beforeClass()
		 {
			CucumberReport.initializeExtentReport();
		 }

		@AfterClass
		 public static void afterClass()
		 {
			CucumberReport.reportCooldown();
		 }
	}

