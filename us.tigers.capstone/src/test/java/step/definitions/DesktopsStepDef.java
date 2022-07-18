package step.definitions;

import core.Base;
import io.cucumber.java.en.*;
import page.objects.DesktopsPage;

public class DesktopsStepDef extends Base {
	DesktopsPage desktopPage = new DesktopsPage();

	@When("User clicks on Desktops tab")
	public void user_clicks_on_desktops_tab() {
	    desktopPage.hoverDesktops();
	    logger.info("user clicked on desktop tab");
	}

	@When("User clicks on Show all desktops")
	public void user_clicks_on_show_all_desktops() {
		desktopPage.clickALlDesktops();
		logger.info("user clicked on show all desktops");
	}

	@Then("User should see all items are present in Desktop page")
	public void user_should_see_all_items_are_present_in_desktop_page() throws InterruptedException {
	    desktopPage.confirmAllDesktops();
	    logger.info("user confirmed all items are present");
	    
	}

	@When("User clicks ADD TO CART option on HP LP3065 item")
	public void user_clicks_add_to_cart_option_on_hp_lp3065_item() {
		desktopPage.addHPLPCart();
		logger.info("user Added HP LP3065 to cart");
	    
	}

	@When("User selects quantity {int}")
	public void user_selects_quantity(Integer int1) {
	    desktopPage.addQuantity(int1);
	    logger.info("user selects the quantity");
	}

	@When("User clicks add to Cart button")
	public void user_clicks_add_to_cart_button() {
	    desktopPage.addToCartFinal();
	    logger.info("user clicked on add to cart button");
	}
	@Then("User should see a success message {string}")
	public void user_should_see_a_success_message(String string) {
		desktopPage.confirmCanon(string);
		logger.info("user saw a confirmation message");
	}

	
	@When("User clicks ADD TO CART option on EOS 5D item")
	public void user_clicks_add_to_cart_option_on_eos_5d_item() throws InterruptedException {
		desktopPage.addCanonCart();
		logger.info("user clicked option Add to cart for EOS 5D item");
	    
	}
	

	@When("User click on Canon EOS 5D item")
	public void user_click_on_canon_eos_5d_item() throws InterruptedException {
		desktopPage.addCanonCart();
		logger.info("user clicks on ite =m EOS 5d item");
		
	}
	
	@When("User click on write a review link")
	public void user_click_on_write_a_review_link() {
	   desktopPage.clickAddReview();
	   logger.info("user clicked write a review link");
	}

	@When("User fill the review information with below information")
	public void user_fill_the_review_information_with_below_information(io.cucumber.datatable.DataTable dataTable) {
	    desktopPage.reviewText(dataTable);
	    logger.info("user filled review information");
	    
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
	    desktopPage.reviewSubmit();
	    logger.info("user clicked on Continue Button");
	}

	@Then("User should see a message with {string}")
	public void user_should_see_a_message_with(String string) {
	    desktopPage.reviewConfirm(string);
	    logger.info("user saw a confirmation message");
	}
}
