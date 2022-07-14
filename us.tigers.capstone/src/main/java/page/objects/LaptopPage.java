package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

import core.Base;
import junit.framework.Assert;
import utilities.Util;

public class LaptopPage extends Base{
	
	public LaptopPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Background page objects 
	@FindBy(xpath = "//a[text()=\"Laptops & Notebooks\"]//ancestor::li")
	private WebElement laptopDrop;
	@FindBy(xpath = "//a[text()=\"Show All Laptops & Notebooks\"]")
	private WebElement allLaptopsLink;
	
	//Adding Macbook scenario
	@FindBy(xpath = "//img[@title=\"MacBook\"]")
	private WebElement mackBookIMG;
	@FindBy(xpath = "//button[@id=\"button-cart\"]")
	private WebElement addToCartBtn;
	@FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible\"]")
	private WebElement successMessage;
	@FindBy(xpath = "//span[@id=\"cart-total\"]")
	private WebElement cartSpan;
	@FindBy(xpath = "//button[@title=\"Remove\"]")
	private WebElement removeBtn;
	
	//Scenario
	@FindBy(xpath = "//button[@onclick=\"compare.add('43');\"]")
	private WebElement macbookCompare;
	@FindBy(xpath = "//button[@onclick=\"compare.add('44');\"]")
	private WebElement macbookAirCompare;
	@FindBy(xpath = "//a[@id='compare-total']")
	private WebElement compareLink;
	@FindBy(xpath = "//thead//ancestor::table")
	private WebElement productCompareTable;
	
	
	//Scenario
	@FindBy(xpath="//button[@onclick=\"wishlist.add('46');\"]")
	private WebElement sonyWishListButton;	
	@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")
	private WebElement alertMessageWishList;
	
	//Scenario
	@FindBy(xpath="//div//div//h4//a[text()=\"MacBook Pro\"]")
	private WebElement macBookPro;
	@FindBy(xpath="//h2[text()=\"$2,000.00\"]")
	private WebElement MackBookProPrice;
	
	
	
	
	
	
	//background
	public void clickAllLaptopDropdown() {
		Actions action = new Actions(driver);
		action.moveToElement(laptopDrop).build().perform();		
	}
	public void clickOnShowAllLaptopsLink() {
		allLaptopsLink.click();
	}
	
	//Scenario
	public void clickMacbook() {
		mackBookIMG.click();
	}
	
	public void addToCart() {
		addToCartBtn.click();
	}
	
	@SuppressWarnings("deprecation")
	public void successMessage(String expected) {
		String actual = Util.getText(successMessage).substring(0,Util.getText(successMessage).length()-2);	
		actual.trim();
		Assert.assertEquals(expected, actual);
		
	}
	
	public void checkCartTotal(String str) {
		Util.confirmText(cartSpan, str);
	}
	
	public void cartClick() {
		cartSpan.click();
	}
	
	public void removeBtnClck() {
		removeBtn.click();
	}
	
	
	
	
	//scenario
	public void clickOnMac(String mackbookText) {
		if(checksIfTextInElement(mackbookText));
		macbookCompare.click();
		
	}
	
	public void clickOnMacAir(String macAirText) {
		if(checksIfTextInElement(macAirText));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		macbookAirCompare.click();	
	}
	
	public void clickOnCompareLink() {
		compareLink.click();
	}
	
	public void checkIfTable() {
		boolean checkCompareTable = productCompareTable.isDisplayed();
		Assert.assertTrue(checkCompareTable);
		
	}
	
	
	
	
	//scenario
	public void clickOnSonyWish() {
		sonyWishListButton.click();
	}
	
	@SuppressWarnings("deprecation")
	public void alertMessageSonyVaio(String expected) {
		String actual =Util.getText(alertMessageWishList).substring(0,Util.getText(alertMessageWishList).length()-2);
		Assert.assertEquals(expected , actual);
		
	}
	
	
	//scenario
	public void clickOnMacbookPro(String str) {
		if(checksIfTextInElement(str));
		macBookPro.click();
		
	}
	
	public void checkIfPriceVisibleMacpro(String str) {
		Util.confirmText(MackBookProPrice, str);
	}
	
	
	
	//helper methods
	
	/**
	 * method return true if the element with the given string is visible
	 * only works in the laptops and notebooks page
	 * @param str
	 * @return
	 */
	
	public boolean checksIfTextInElement(String str) {
		String strFormat = String.format("//div//div//h4//a[text()=\"%s\"]",str);
		WebElement elem = driver.findElement(By.xpath(strFormat));
		boolean checkIfDisplayed = elem.isDisplayed();
		return checkIfDisplayed;
		
	}
	
	
	

}
