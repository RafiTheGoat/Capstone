package page.objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import core.Base;
import io.cucumber.datatable.DataTable;
import utilities.Util;

public class DesktopsPage extends Base{
	public DesktopsPage() {
		PageFactory.initElements(driver,this);
		
	}
	//Background
	@FindBy(xpath="//a[text()=\"Desktops\"]")
	private WebElement Desktops;	
	@FindBy(xpath="//a[text()=\"Show All Desktops\"]")
	private WebElement allDesktops;
	
	//User verify all items are present in the Desktops tab
	@FindBy(xpath="//h2[text()]")
	private WebElement allDesktopsText;
	@FindBy(xpath="//div[@id=\"content\"]//descendant::div[@class=\"row\"][4]")
	private List<WebElement> allDesktopsPage;
	
	// User add HP LP 3065 from Desktops tab to the cart
	@FindBy(xpath="//button[@onclick=\"cart.add('47', '1');\"]")
	private WebElement HPLPCartButton;
	@FindBy(xpath="//input[@name='quantity']")
	private WebElement quantityHPLP;
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement AddToCartFinal;
	
	//User add Canon EOS 5D from Desktops tab to the cart
	@FindBy(xpath="//button[@onclick=\"cart.add('30', '1');\"]")
	private WebElement CanonEOS;
	@FindBy(xpath= "//select")
	private WebElement colorOfCanonEOS;
	
	//User add a review to Canon EOS 5D item in Desktops tab
	@FindBy(xpath="//a[text()='Write a review']")
	private WebElement reviewLink;
	@FindBy(xpath="//input[@name='name']")
	private WebElement reviewName;
	@FindBy(xpath="//textarea")
	private WebElement reviewText;
	@FindBy(xpath="//button[@id='button-review']")
	private WebElement reviewSubmit;
	@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")
	private WebElement SubmitConfirm;
	
	
	

	public void hoverDesktops() {
		Actions action = new Actions(driver);
		action.moveToElement(Desktops).build().perform();
		
	}
	
	public void clickALlDesktops() {
		allDesktops.click();
	}
	
	public void confirmAllDesktops() {
	//	System.out.println(allDesktopsPage.size());
		Assert.assertTrue(allDesktopsPage.size()>=0 &&  allDesktopsText.isDisplayed());
	
	}
	public void addHPLPCart() {
		HPLPCartButton.click();
		
	}
	
	public void addQuantity(Integer in) {
		quantityHPLP.clear();
		quantityHPLP.sendKeys(String.valueOf(in));
	}
	
	public void addToCartFinal() {
		AddToCartFinal.click();
	}
	
	
	
	public void addCanonCart() throws InterruptedException {
		CanonEOS.click();
		Thread.sleep(2000);
		Select select = new Select(colorOfCanonEOS);
		select.selectByIndex(1);
	}
	
	public void confirmCanon(String expected) {
		String withoutExtra = Util.getText(SubmitConfirm).substring(0,Util.getText(SubmitConfirm).length()-2);
		Assert.assertEquals(expected, withoutExtra);
	}
	
	public void clickAddReview() {

		reviewLink.click();
	}
	
	public void reviewText(DataTable table) {
		List<Map<String, String>> data = table.asMaps(String.class,String.class);
		reviewName.sendKeys(data.get(0).get("yourname"));
		reviewText.sendKeys(data.get(0).get("review"));
		ratingSel(Integer.parseInt(data.get(0).get("Rating")));	
	}
	
	public void reviewSubmit() {
		reviewSubmit.click();
	}
	

	public void reviewConfirm(String str) {
		Util.confirmText(SubmitConfirm, str);
		
	}
	
	/**
	 * selects the radio button based on the review left by the customer from 1(bad) to  5(best)
	 * @param i
	 */
	public void ratingSel(int i) {
		String seEl = String.format("//input[@type=\"radio\" and @value='%s']", i);
		WebElement rating = driver.findElement(By.xpath(seEl));
		if(rating.isDisplayed() && rating.isEnabled()) {
			rating.click();
		}else throw new  NoSuchElementException(seEl);
		
	}
	
}










