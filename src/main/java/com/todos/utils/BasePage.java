package com.todos.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import atu.testrecorder.ATUTestRecorder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ATUTestRecorder recorder;

	public BasePage() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/com/todos/configs/config.properties");
		prop.load(fis);

	}

	public static void initialization(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			// System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			// System.setProperty("webdriver.geckodriver.driver",
			// prop.getProperty("firefox"));
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		driver = e_driver;

	}

	public void WriteText(WebElement element , String  text ) {
		
		driver.findElement((By)element).clear();
		driver.findElement((By)element).sendKeys(text);
		
	}

	public void clickButton(WebElement element) {
		
		
		driver.findElement((By)element).click();
	}

}
