package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import core.Base;
import junit.framework.Assert;

public class Util extends Base {

	//Util class for re-usable methods in our testing framework 

	public static String screenShotName() {

		Date date = new Date();
		String screenShot = date.toString().replace(":", "_").replace(" ", "_");
		return screenShot;

	}

	public static void takeScreenShot() {

		String location = System.getProperty("user.dir") + "\\output\\screenshots\\";
		String screenShotFileName = screenShotName() + ".png";

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File(location + screenShotFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception in execution");
		}

	}

	/**
	 * This method will select the value from static Dropdown by visible value
	 * 
	 * @param element
	 * @param text
	 */
	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	/**
	 * This method will select value from static Dropdown by index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method will select value from static dropdown by value
	 * 
	 * @param element
	 * @param value
	 */
	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	
	/**
	 * This method will return text of element
	 * 
	 * @param ele
	 * @return
	 */
	public static String getText(WebElement ele) {
		String ElementText = ele.getText();
		return ElementText;
	}

	/**
	 * This method will drag and drop using Actions class
	 * 
	 * @param sourceElement
	 * @param targetElement
	 */
	public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement, targetElement);

	}

	public static boolean isElementDisplayed(WebElement element) {
		if (element.isDisplayed())
			return true;
		else
			return false;

	}
	
	/**
	 * this method will confirm if the text given is displayed on the page
	 * @param elem
	 * @param expectedText
	 */
	
	@SuppressWarnings("deprecation")
	public static void confirmText(WebElement elem, String expectedText) {
		String actual = Util.getText(elem);
		String expected = expectedText;
		
		Assert.assertEquals(expected, actual);
		
		
	}
	
	

}
