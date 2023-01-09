package com.todos.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class is used to perform various kinds of validations in the test cases.
 */
public class Validations extends BasePage {

	/** testCaseStatus the status of the test case. */
	boolean testCaseStatus = true;

	/** test status. */
	boolean testStatus;

	/** test screenshot dir. */
	private String testScreenshotDir;

	private WebDriver driver;

	/**
	 * Instanciation de assertions.
	 * @throws IOException 
	 */
	public Validations() throws IOException {
		super();
		this.driver = driver;
	}

	/**
	 * method verify whether element is present on screen.
	 *
	 * @param targetElement element to be present
	 * @return true if element is present else throws exception
	 */
	public Boolean isElementPresent(By targetElement) {
		return driver.findElements(targetElement).size() > 0;
	}

	/**
	 * methode Checks if is element displayed.
	 *
	 * @param element element web
	 * @return boolean
	 */
	public Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * methode Checks if is element selected
	 *
	 * @param element
	 * @return boolean
	 */
	public Boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	/**
	 * methode Checks if is element enabled.
	 *
	 * @param element
	 * @return boolean
	 */
	public Boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * method verify whether element is not present on screen.
	 *
	 * @param targetElement element not to be present
	 * @return true if element is not present else throws exception
	 */
	public Boolean isElementNotPresent(By targetElement) {
		return driver.findElements(targetElement).size() == 0;
	}

	/**
	 * method to take screenshot.
	 *
	 * @return path where screenshot has been saved
	 */
	public String screenShot() {
		String screenshotPath = "screenshot"
				+ new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss", Locale.FRANCE).format(new GregorianCalendar().getTime())
				+ ".png";

		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(testScreenshotDir + screenshotPath));
		} catch (IOException e) {
			
			screenshotPath = "";
		}
		return screenshotPath;
	}



	/**
	 * methode Check field is empty.
	 * 
	 * @param elementAttr
	 */
	public void checkFieldIsEmpty(WebElement elementAttr) {
		WebElement inputText = elementAttr;
		String text = inputText.getAttribute("value");

		if (text.isEmpty()) {
			
		}
	}

}