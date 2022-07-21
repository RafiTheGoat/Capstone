package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

import core.Base;
import junit.framework.Assert;
import utilities.Util;

public class LaptopPage extends Base{
	
	public LaptopPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Background page objects 
	@FindBy(xpath = "//a[text()=\"Laptops & Notebooks\"]")
	private WebElement laptopDrop;
	@FindBy(xpath = "//a[text()=\"Show All Laptops & Notebooks\"]")
	private WebElement allLaptopsLink;
	
	//Adding Macbook scenario
	@FindBy(xpath = "//img[@title=\"MacBook\"]")
	private WebElement mackBookIMG;
	@FindBy(xpath = "//button[@id=\"button-cart\"]")
	private WebElement addToCartBtn;
	@FindBy(xpath = "//span[@id=\"cart-total\"]")
	private WebElement cartSpan;
	@FindBy(xpath = "//button[@title=\"Remove\"]")
	private WebElement removeBtn;
	
	//Scenario Macbook Compare
	@FindBy(xpath = "//a[@id='compare-total']")
	private WebElement compareLink;
	@FindBy(xpath = "//thead//ancestor::table")
	private WebElement productCompareTable;
	
	//Scenario Sony Wishlist
	@FindBy(xpath="//button[@onclick=\"wishlist.add('46');\"]")
	private WebElement sonyWishListButton;	
	
	//Scenario MAckbook Air Price
	@FindBy(xpath="//div//div//h4//a[text()=\"MacBook Pro\"]")
	private WebElement macBookPro;
	@FindBy(xpath="//h2[text()=\"$2,000.00\"]")
	private WebElement MackBookProPrice;
	
	//background
	public void clickAllLaptopDrop() {
		
		Actions action = new Actions(driver);
		action.moveToElement(laptopDrop).build().perform();	
		
		
	}
	public void clickOnShowAllLaptopsLink() {
		allLaptopsLink.click();
	}
	
	//Scenario Adding macbook to cart
	public void clickMacbook() {
		mackBookIMG.click();
	}
	
	public void addToCart() {
		addToCartBtn.click();
	}

	
	public void checkCartTotal(String str) {
		Util.confirmText(cartSpan, str);
	}
	
	public void cartClick() {
		cartSpan.click();
	}
	
	public void removeBtnClck() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(removeBtn));
		removeBtn.click();
	}
	

	//scenario comparing Macs
	public void clickOnMac(String mackbookText) {
		clicksIfTextInElement(mackbookText);		
	}

	
	public void clickOnCompareLink() {
		compareLink.click();
	}
	
	public void checkIfTable() {
		boolean checkCompareTable = productCompareTable.isDisplayed();
		Assert.assertTrue(checkCompareTable);	
	}
	
		
	//scenario wishlisting sony vaio
	public void clickOnSonyWish() {
		sonyWishListButton.click();
	}
	
	
	//scenario checking mackbook Pro price
	public void clickOnMacbookPro(String str) {
		macBookPro.click();
		
	}
	
	public void checkIfPriceVisibleMacpro(String str) {
		Util.confirmText(MackBookProPrice, str);
	}
	
	
	
	//helper methods for this Feature
	/**
	 * Clicks on the Element if it has a header equal to the String passed.
	 * only works in the laptops and notebooks page
	 * @param str
	 * @return
	 */
	
	public void clicksIfTextInElement(String str) {
		//Finding the header for the Element EX: Macbook Pro.
		String strFormat = String.format("//div//div//h4//a[text()=\"%s\"]",str);
		WebElement elemTitle = driver.findElement(By.xpath(strFormat));
		//Clicking on the Product compare button of the same ELement(Div).
		if(elemTitle.isDisplayed()) {
			//Finding the Product compare Button for the same Element.
			String strAddToCart = String.format("//div//div//h4//a[text()=\"%s\"]//ancestor::div[@class=\"caption\"]/following-sibling::div//descendant::button[3]", str);
			WebElement elemAddToCart = driver.findElement(By.xpath(strAddToCart));
			if(elemAddToCart.isDisplayed()) {
				elemAddToCart.click();
			}else throw new NoSuchElementException(strAddToCart);
		}
	}
	
	/**
	 * Method to check for a success message in the laptop and notebooks page and validates whether true.
	 * @param str
	 */
	
	@SuppressWarnings("deprecation")
	public void successMessage(String expected) {
		WebElement succMessage = driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]"));
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(succMessage));
		String actual = Util.getText(succMessage).substring(0,Util.getText(succMessage).length()-2).trim();
		Assert.assertEquals(expected,actual);
		
	}
}
