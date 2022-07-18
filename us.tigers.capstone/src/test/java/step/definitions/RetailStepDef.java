package step.definitions;

import core.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.RetailPage;

public class RetailStepDef extends Base{
RetailPage retailPage = new RetailPage();

	
	//Background step defs
	@Given("User click on MyAccount")
	public void user_click_on_my_account() {
		retailPage.clickMyAccountDrop();
		logger.info("User clicked on my account dropdown"); 
	}

	@When("User click on Login")
	public void user_click_on_login() {
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
	
	
	
	
	//Scenario 1
	//this method will repeat 3 times in the Feature 
	@When("User click on {string} link")
	public void user_click_on_link(String link) {
		
	    retailPage.clickIfLinkHasText(link);
	    String loggerMessage = String.format("user clicked on %s",link);
	    logger.info(loggerMessage);  
	}

	@When("User fill affiliate form with below information")
	public void user_fill_affiliate_form_with_below_information(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		retailPage.fillAffiliateLinkDetails(dataTable);
		logger.info("User fills the affiliate link form");	 
		Thread.sleep(2000);
	}

	@When("User click on Continue button")
	public void user_click_on_Continue_button() {
	  retailPage.continueButton();
	  logger.info("User clicks continue button");
	}

	//this method will repeat 3 times in the Feature
	@Then("User should see a message {string}")
	public void user_should_see_a_success_message(String str) {
		retailPage.checkSuccess(str);
		logger.info("checked whether update was successful");
	}
	
		
	//scenario 2
	@When("user click on Bank Transfer radio button")
	public void user_click_on_bank_transfer_radio_button() {
	    retailPage.clickEditAffiliate();
	    logger.info("Edit affiliate link clicked");
	}

	@When("User fill Bank information with below information")
	public void user_fill_bank_information_with_below_information(io.cucumber.datatable.DataTable dataTable) {
		retailPage.fillEditAffiliate(dataTable);
		logger.info("Affiliate information updated.");
	}
	
	
	
	//Scenario 3
	@When("User modify below information")
	public void user_modify_below_information(io.cucumber.datatable.DataTable dataTable) {
	    retailPage.editData(dataTable);
	    logger.info("User updates their account information");
	}
	


}
