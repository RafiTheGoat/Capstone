package step.definitions;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Initializer extends Base {
	
	/*
	 * This class hosts two methods that will run before and after each scenario
	 * Cucumber has Hooks and we have BeforeHooks and AfterHooks
	 * Before Hooks executes a block of code before each scenario
	 * After Hooks executes a block of code after each scenario 
	 */
	@Before
	public void beforeHooks(Scenario scenario) {
		logger.info("Scenario " + scenario.getName() + " started");
		selectBrowser(); // this method will select the browser 
		launchBrowser(); // this method will launch the browser
		
		HomeStepDef home = new HomeStepDef();
		home.user_is_on_retail_website(); // this method will check if we are on reatil page
		
	}
	
	
	
	@After
	public void afterHooks(Scenario scenario) {
		tearDown();
		logger.info("Scenario " +scenario.getName() + " " +scenario.getStatus());
		
	}

}
