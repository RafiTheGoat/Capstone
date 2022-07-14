package page.objects;
import java.util.List;
import java.util.Map;

import org.junit.Assert;


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
	
	@FindBy(xpath="//a[text()=\"Desktops\"]")
	private WebElement Desktops;
	
	@FindBy(xpath="//a[text()=\"Show All Desktops\"]")
	private WebElement allDesktops;
	
	@FindBy(xpath="//h2[text()]")
	private WebElement allDesktopsText;
	
	@FindBy(xpath="//button[@onclick=\"cart.add('47', '1');\"]")
	private WebElement HPLPCartButton;
	
	@FindBy(xpath="//input[@name='quantity']")
	private WebElement quantityHPLP;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement AddToCartFinal;
	
	@FindBy(xpath="//button[@onclick=\"cart.add('30', '1');\"]")
	private WebElement CanonEOS;
	
	@FindBy(xpath= "//select")
	private WebElement colorOfCanonEOS;
	
	
	@FindBy(xpath="//a[text()='Write a review']")
	private WebElement reviewLink;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement reviewName;
	
	@FindBy(xpath="//textarea")
	private WebElement reviewText;
	
	@FindBy(xpath="//input[@name=\"rating\"]/ancestor::div[@class=\"col-sm-12\"][1]")
	private List <WebElement> reviewRadioBtn;
	
	@FindBy(xpath="//input[@name='rating' and @value='1']")
	private WebElement reviewRating1;
	
	@FindBy(xpath="//input[@name='rating' and @value='2']")
	private WebElement reviewRating2;
	
	@FindBy(xpath="//input[@name='rating' and @value='3']")
	private WebElement reviewRating3;
	
	@FindBy(xpath="//input[@name='rating' and @value='4']")
	private WebElement reviewRating4;
	
	@FindBy(xpath="//input[@name='rating' and @value='5']")
	private WebElement reviewRating5;
	
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
	
	public void confirmText() throws InterruptedException {
		Thread.sleep(2000);
		String actual = Util.getText(allDesktopsText);
		String expected = "Desktops";
		Assert.assertEquals(expected, actual);
		
		
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
		//colorOfCanonEOS.click();
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
		utilities.Util.confirmText(SubmitConfirm, str);
		
	}
	
	
	
	public void ratingSel(int i) {
		switch(i) {
		case 1: 
			reviewRating1.click();
			break;
		
		case 2: 
			reviewRating2.click();
			break;
		
		case 3:
			reviewRating3.click();
			break;
		case 4:
			reviewRating4.click();
			
		case 5:
			reviewRating5.click();
		}
		
		
		
	}
	
	
	
	
	
}










