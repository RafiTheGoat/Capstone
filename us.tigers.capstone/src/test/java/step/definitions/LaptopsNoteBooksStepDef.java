package step.definitions;

import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.LaptopPage;

public class LaptopsNoteBooksStepDef extends Base{
	LaptopPage laptopPage = new LaptopPage();
	
	//background step definitions
	@When("User clicks on Laptop & Notebook option")
	public void user_clicks_on_show_all_laptop_notebook_option() {
	    laptopPage.clickAllLaptopDrop();
	    logger.info("user clicks laptops and notebooksc drop down");
	}
	@And("User clicks on Show all Laptop & Notebook option")
	public void userClicksOnShowAllLaptopNotebookOption(){
		laptopPage.clickOnShowAllLaptopsLink();
		 logger.info("user clicks on show all laptops and notebooks");
	}

	//scenario
	@When("User clicks on MackBook item")
	public void user_clicks_on_mack_book_item() {
	   laptopPage.clickMacbook();
	   logger.info("user clicks on MacBook item");
	}

	@When("User click add to cart button")
	public void user_click_add_to_cart_button() {
	    laptopPage.addToCart();
	    logger.info("user clicks on add to cart button");
	}
	

	@Then("User should see a sucess message {string}")
	public void user_should_see_a_success_message(String string) {
	    laptopPage.successMessage(string);
	    logger.info("User sees success message ");
	}
	
	@Then("User should see {string} displayed from the cart")
	public void user_should_see_displayed_from_the_cart(String string) {
	    laptopPage.checkCartTotal(string);
	    logger.info("User sees the message displayed from the cart");
	}

	@Then("User clicks on cart option")
	public void user_clicks_on_cart_option() {
	    laptopPage.cartClick();
	    logger.info("User clicks on the cart option");
	}

	@Then("User clicks on red X button to remove the item from the cart")
	public void user_clicks_on_red_x_button_to_remove_the_item_from_the_cart() {
	    laptopPage.removeBtnClck();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    logger.info("User clicks on X button to remove item forom Cart");
	}
	
	@Then("item should be removed and cart should show {string}")
	public void item_should_be_removed_and_cart_should_show(String string) {
		laptopPage.checkCartTotal(string);
		logger.info("User sees that the item is removed");
	}
	
	//scenario
	 @And("User clicks on product comparison icon on {string}")
	 public void User_clicks_on_macbook_and_mackbookAir_compare(String str) throws InterruptedException {
		 laptopPage.clickOnMac(str);
		 Thread.sleep(2000);
		 logger.info(String.format("User clciked on %s",str));
	 }
	 
	 
	 @And("User clicks on comparison link")
	 public void user_clicks_comparison_link() {
		 laptopPage.clickOnCompareLink();
		 logger.info("Users clicks on comparison link");
	 }
	 
	 @Then("User should see product comparison chart")
	 public void user_sees_compare_table() {
		 laptopPage.checkIfTable();
		 logger.info("User sees the comparison chart");
	 }
	 
	 //scenario
	 @When("User clicks on heart icon to add Sony Vaio laptop to wish list")
	 public void user_clciks_on_heart_icon_to_add_sony_vaio_laptop_to_wish_list() {
	    laptopPage.clickOnSonyWish();
	    logger.info("User wishlists SOny Vaio");
	 }
	 
	 //scenario
	 @When("User click on {string} item")
	 public void user_click_on_item(String string) {
		 laptopPage.clickOnMacbookPro(string);
		 logger.info("User clicks on MacBook Pro item");
	 }

	 @Then("User should see  {string} price tag is present on UI.")
	 public void user_should_see_price_tag_is_present_on_ui(String string) {
	     laptopPage.checkIfPriceVisibleMacpro(string);
	     logger.info("user sees the price tag for MacBook Pro");
	 }
	 
}
