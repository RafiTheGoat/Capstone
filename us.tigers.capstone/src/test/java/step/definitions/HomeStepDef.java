package step.definitions;

import org.junit.Assert;

import core.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.HomePage;

public class HomeStepDef extends Base{
HomePage homepage = new HomePage();
	
	@Given("User is on Retail website")
	public void user_is_on_retail_website() {
	    homepage.homePageVis();
	    logger.info("User is on the main page");
	}

	@When("User clicks on Currency")
	public void user_clicks_on_currency() {
	    homepage.ClickOnCurrency();
	    logger.info("User clicked on currency drop down");
	}

	@When("User Chooses Euro from dropdown")
	public void user_chooses_euro_from_dropdown() {
		homepage.ClickOnEuro();
		 logger.info("User chose Euro from currency drop down");
	}

	@Then("Currency Value should change to Euro")
	public void currency_value_should_change_to_euro() {
		homepage.CheckIfEuro();
		 logger.info("Currency changed to Euro");
	    
	}

	@When("User Cliks on shopping cart")
	public void user_cliks_on_shopping_cart() {
	    homepage.clickShoppingCart();
	    logger.info("User clicked on Shopping cart");
	}

	@Then("{string} message should be displayed")
	public void message_should_be_displayed(String string) {
		String ActualText = utilities.Util.getText(homepage.cartText);
		
		String ExpectedText = string;
		Assert.assertEquals(ExpectedText,ActualText);
		 logger.info("Message was displayed");
	}	

}
