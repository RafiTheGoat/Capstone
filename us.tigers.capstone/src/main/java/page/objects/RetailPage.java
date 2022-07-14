package page.objects;

import org.openqa.selenium.support.PageFactory;


import java.util.List;
import java.util.Map;

import org.junit.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.Base;
import io.cucumber.datatable.DataTable;

public class RetailPage extends Base{
	
	public RetailPage() {
		PageFactory.initElements(driver,this);
		
	}
	
	//page objects for the review scenario
	
	@FindBy(xpath="//a[@title=\"My Account\"]")
	private WebElement myAccountDrop;
	
	@FindBy(xpath ="//a[text()=\"Login\"]")
	private WebElement loginHomeButton;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailText;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordText;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//H2[text()='My Account']")
	private WebElement dashboardText;

	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='My Account']")
	private WebElement  myAccountButton;
	
	//page objects for the affiliate link scenario
	
	@FindBy(xpath="//a[text()='Register for an affiliate account']")
	private WebElement  affiliateLinkText;
	
	@FindBy(xpath="//input[@name='company']")
	private WebElement  companyText;
	
	@FindBy(xpath="//input[@name='website']")
	private WebElement  websiteLinkText;
	
	@FindBy(xpath="//input[@name='tax']")
	private WebElement  taxidLinkText;
	
	@FindBy(xpath="//input[@value='cheque']")
	private WebElement chequeRadioBut;
	
	@FindBy(xpath="//input[@name='cheque']")
	private WebElement payeeName;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreementTick;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	

	//page objects for edit account scenario
	
	@FindBy(xpath="//a[text()=\"Edit your account information\"]")
	private WebElement editAccountLink;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='telephone']")
	private WebElement phone;
	
	
	@FindBy(xpath="//div[text()=' Success: Your account has been successfully updated.']")
	private WebElement editSuccessText;
	
	@FindBy(xpath="//div[text()=' Success: Your account has been successfully updated.']")
	private WebElement editSuccessText1;
	
	
	
	
	public void clickMyAccountDrop() {
		myAccountDrop.click();
		
	}
	
	public void clickOnLogin() {
		loginHomeButton.click();
	}
	
	public void register(String email, String pass) {
		emailText.sendKeys(email);
		passwordText.sendKeys(pass);
		
	}
	
	public void submitLogin() {
		loginButton.click();
		
	}
	
	public void loginSuccessCheck() {
		String actualText =utilities.Util.getText(dashboardText);
		String expectedText = "My Account";
		Assert.assertEquals(expectedText,actualText);
		
		
	}
	
	
	public void clickOnAffiliateLink(String link) {
		String actualText =utilities.Util.getText(affiliateLinkText);
		String expectedText = link;
		Assert.assertEquals(expectedText,actualText);
		
		affiliateLinkText.click();
	}
	
	public void fillAffiliateLinkDetails(DataTable dataTable) {
	    List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		   
		companyText.sendKeys(data.get(0).get("company"));
		websiteLinkText.sendKeys(data.get(0).get("website"));
		taxidLinkText.sendKeys(data.get(0).get("taxID"));
		chequeRadioBut.click();
		payeeName.sendKeys(data.get(0).get("company"));
		agreementTick.click();
		
		
		
	}
	
	public void continueButton() {
		continueButton.click();
	}
	
	public void checkIfSuccessEdit() {
		String actual =utilities.Util.getText(editSuccessText);
		String expected = "Success: Your account has been successfully updated.";
		Assert.assertEquals(expected,actual);
	
	}
	
	
	public void editInfo(String link) {
		String actual =utilities.Util.getText(editAccountLink);
		String expected = "Edit your account information";
		Assert.assertEquals(expected,actual);
		
		editAccountLink.click();
	}
	
	public void editData(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		firstName.sendKeys(data.get(0).get("firstName"));
		lastName.sendKeys(data.get(0).get("lastName"));
		email.clear();
		email.sendKeys(data.get(0).get("email"));
		phone.sendKeys(data.get(0).get("phone"));
		
		
	}
	
	public void checkIfSuccessEditInfo() {
		String actual =utilities.Util.getText(editSuccessText1);
		String expected = "Success: Your account has been successfully updated.";
		Assert.assertEquals(expected,actual);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
