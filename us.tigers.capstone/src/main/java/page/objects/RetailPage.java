package page.objects;

import org.openqa.selenium.support.PageFactory;


import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.Base;
import io.cucumber.datatable.DataTable;
import utilities.Util;

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
	@FindBy(xpath="//input[@name='company']")
	private WebElement  companyText;
	@FindBy(xpath="//input[@name='website']")
	private WebElement  websiteLinkText;
	@FindBy(xpath="//input[@name='tax']")
	private WebElement  taxidLinkText;
	@FindBy(xpath="//input[@value='cheque']")
	private WebElement chequeRadioBut;
	@FindBy(xpath="//input[@placeholder=\"Cheque Payee Name\"]")
	////input[@name="cheque"]
	private WebElement payeeName;
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreementTick;
	@FindBy(xpath="//div[text()=' Success: Your account has been successfully updated.']")
	private WebElement successText;		
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	//Page objects for edit Affiliate link scenario
	@FindBy(xpath="//input[@value='bank']")
	private WebElement bankTransferRadioBtn;
	@FindBy(xpath="//input[@name=\"bank_name\"]")
	private WebElement bankNameInput;
	@FindBy(xpath="//input[@name=\"bank_branch_number\"]")
	private WebElement branchNumInput;
	@FindBy(xpath="//input[@name=\"bank_swift_code\"]")
	private WebElement swiftCodeInput;
	@FindBy(xpath="//input[@name=\"bank_account_name\"]")
	private WebElement actNameInput;
	@FindBy(xpath="//input[@name=\"bank_account_number\"]")
	private WebElement actNumInput;
	
	//page objects for edit account scenario
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;	
	@FindBy(xpath="//input[@name='telephone']")
	private WebElement phone;
	
	
	
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
		String expectedText = "My Account";
		Util.confirmText(dashboardText, expectedText);				
	}
	
	//affiliate link scenario
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
	
	//Edit affiliate scenario
	public void clickEditAffiliate() {
		bankTransferRadioBtn.click();
	}
	public void fillEditAffiliate(DataTable editAffiliate) {
		List<Map<String, String>> data = editAffiliate.asMaps(String.class, String.class);
		bankNameInput.sendKeys(data.get(0).get("bankName"));
		branchNumInput.sendKeys(data.get(0).get("abaNumber"));
		swiftCodeInput.sendKeys(data.get(0).get("swiftCode"));
		actNameInput.sendKeys(data.get(0).get("accountName"));
		actNumInput.sendKeys(data.get(0).get("accountNumber"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
	}
	
	//Edit account info scenario
	public void editData(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		firstName.sendKeys(data.get(0).get("firstName"));
		lastName.sendKeys(data.get(0).get("lastName"));
		email.clear();
		email.sendKeys(data.get(0).get("email"));
		phone.sendKeys(data.get(0).get("phone"));		
	}
	
	
	//helper methods for this feature
	
	/**
	 * Finds element with help of text() method and string passed, then clicks on the link
	 * @param el
	 * @param linkText
	 */
	public void clickIfLinkHasText(String linkText) {
		String searchEl = String.format("//a[text()=\"%s\"]",linkText);
		WebElement foundEl = driver.findElement(By.xpath(searchEl));
		if(foundEl.isDisplayed()) {
			foundEl.click();
		}else {
			throw new NoSuchElementException(searchEl);
		}		
	}
	
	/**
	 * Checks if success message is displayed.
	 * success message is the same for all the scenarios.
	 * @param successMessage
	 */
	public void checkSuccess(String successMessage) {
		if(successText.isDisplayed()) {
			 Assert.assertEquals(successMessage,successText.getText().trim());		 
		}else throw new NoSuchElementException(successMessage);
	}
	
}
