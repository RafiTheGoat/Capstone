package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.CucumberReportingConfig;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "classpath:features",
		glue = "step.definitions",
		tags = "@Home",
		dryRun = false,
		monochrome = true,
		
		plugin = {"pretty",
				"html:/Users/owner/git/repository/us.tigers.capstone/target/site/cucumber-pretty",
			    "json:/Users/owner/git/repository/us.tigers.capstone/target/cucumber.json"},
		publish = true
		
		
		)

public class Runner {
	
	@AfterClass
	public static void generateReport() {
		CucumberReportingConfig.reportConfig();
	}
	

}
