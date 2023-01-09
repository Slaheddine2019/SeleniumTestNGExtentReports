package com.todos.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Setup extends BasePage {

	public CommandsUtils commands;

	public Setup() throws IOException {
		super();
		commands = new CommandsUtils();
	}

	@BeforeSuite
	public void runBeforeSuite() {

		extent = new ExtentReports("C:\\Users\\INFOKOM\\eclipse-workspace\\selenium-testng-reports\\target\\index.html", true);
		extent.addSystemInfo("ProjectName", "First testNG project");
		extent.addSystemInfo("Tester", "Slah Eddine Jeder");
		
	}

	@AfterSuite
	public void runAfterSuite() {

		extent.flush();
		driver.quit();

	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void setupTest(String browser, Method method) throws ATUTestRecorderException {
		recorder = new ATUTestRecorder("C:\\Users\\INFOKOM\\eclipse-workspace\\selenium-testng-reports\\target", method.getName(),
				false);
		recorder.start();
		logger = extent.startTest(method.getName());
		initialization(browser);
		driver.get(prop.getProperty("home.url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

	}

	@AfterMethod
	public void cleanTest(Method method, ITestResult result) throws IOException, ATUTestRecorderException {

		if (result.getStatus() == ITestResult.SUCCESS) {

			logger.log(LogStatus.PASS, "Test is passed.");
			CommandsUtils.takesScreenShot(method.getName());
			logger.log(LogStatus.PASS, "<a href='" + result.getName() + ".png"	+ "'><span class='lable info'>Download snapshot </span></a>");
			logger.log(LogStatus.PASS, "<a href='" + result.getName() + ".mov"  + "'><span class='lable info'>Download video </span></a>");

		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			
			logger.log(LogStatus.FAIL, "Test is failed.");
			logger.log(LogStatus.FAIL, result.getThrowable());
			CommandsUtils.takesScreenShot(method.getName());
			logger.log(LogStatus.FAIL, "<a href='" + result.getName() + ".png"	+ "'><span class='lable info'>Download snapshot </span></a>");
			logger.log(LogStatus.FAIL, "<a href='" + result.getName() + ".mov"  + "'><span class='lable info'>Download video </span></a>");

		}

		else if (result.getStatus() == ITestResult.SKIP) {

			logger.log(LogStatus.SKIP, "Test is skipped.");
			

		}

		driver.navigate().refresh();
		driver.close();
		recorder.stop();
	}
}
