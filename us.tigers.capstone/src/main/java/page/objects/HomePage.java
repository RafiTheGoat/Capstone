package page.objects;

import org.junit.Assert;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class HomePage extends Base{
	
	public HomePage() {
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//a[text()= \"TEST ENVIRONMENT\"]")
	private WebElement homeText;
	
	@FindBy(xpath="//i[@class='fa fa-caret-down']")
	private WebElement CurrencyDropDown;
	
	@FindBy(xpath="//button[@name='EUR']")
	private WebElement CurrencyEuro;
	
	@FindBy(xpath= "//strong")
	private WebElement CurrentCurrency;
	
	@FindBy(xpath = "//a[@title='Shopping Cart']")
	private WebElement ShoppingCart;
	@FindBy(xpath = "//div[@class='col-sm-12']//p[text()='Your shopping cart is empty!']")
	public WebElement cartText;
	
	
	
	public void homePageVis() {
		String actualText = "TEST ENVIRONMENT";
		String expectedText = utilities.Util.getText(homeText);
		Assert.assertEquals(expectedText, actualText);
		
	
	}
	
	public void ClickOnCurrency() {
		CurrencyDropDown.click();
		
	}
	
	public void ClickOnEuro() {
		CurrencyEuro.click();
	}
	
	
	public void CheckIfEuro() {
		String ActualText = utilities.Util.getText(CurrentCurrency);
		String ExpectedText = "€";
		Assert.assertEquals(ExpectedText,ActualText);
	}
	
	
	public void clickShoppingCart() {
		ShoppingCart.click();
	}
	
		

}
