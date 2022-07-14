package step.definitions;

import core.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.RetailPage;

public class RetailStepDef extends Base{
RetailPage retailPage = new RetailPage();
	
	@Given("User click on MyAccount")
	public void user_click_on_my_account() {
		retailPage.clickMyAccountDrop();
		logger.info("User clicked on my account dropdown");
	    
	}

	@When("User click on Login")
	public void user_click_on_login() {
		retailPage.clickMyAccountDrop();
		retailPage.clickOnLogin();
		logger.info("User clicked on login");
		
		
	}

	@When("User enter username {string} and password {string}")
	public void user_enter_username_and_password(String email, String pass) {
		retailPage.register(email, pass);
		
		logger.info("User input email and password");
	    
	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
	    retailPage.submitLogin();
	    logger.info("User clicks on login button");

	}

	@Then("User should be logged in to MyAccount dashboard")
	public void user_should_be_logged_in_to_my_account_dashboard() {
	    retailPage.loginSuccessCheck();
	    logger.info("success message checked");

	    
	}
	
	
	
	

	@When("User click on {string} link")
	public void user_click_on_link(String link) {
	    retailPage.clickOnAffiliateLink(link);
	    logger.info("User clicks on affiliate link");

	    
	}

	@When("User fill affiliate form with below information")
	public void user_fill_affiliate_form_with_below_information(io.cucumber.datatable.DataTable dataTable) {
		retailPage.fillAffiliateLinkDetails(dataTable);
		logger.info("User fills the affiliate link form");

	   
	}

	@When("User click on Continue button")
	public void user_click_on_Continue_button() {
	  retailPage.continueButton();
	  logger.info("User clicks continue button");

	}

	@Then("User should see a success message")
	public void user_should_see_a_success_message() {
	    retailPage.checkIfSuccessEdit();
	    logger.info("success message checked");
	    
	}
	
	
	


	@When("User clicks on {string} link")
	public void user_clicks_on_link(String string) {
	    retailPage.editInfo(string);
	    logger.info("User clicks on the review link");
	}

	@When("User modify below information")
	public void user_modify_below_information(io.cucumber.datatable.DataTable dataTable) {
	    retailPage.editData(dataTable);
	    logger.info("User inputs their review");
	}

	@When("User click on continue button")
	public void user_click_on_continue_button() {
		retailPage.continueButton();
		 logger.info("User clicks on continue button after review");
	    
	}

	@Then("User should see a message {string}")
	public void user_should_see_a_message(String string) {
		retailPage.checkIfSuccessEditInfo();
		 logger.info("success message checked after review");
	}

}
