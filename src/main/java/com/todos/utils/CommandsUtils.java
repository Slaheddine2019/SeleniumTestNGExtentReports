package com.todos.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommandsUtils extends BasePage {
	
	
	
	
public CommandsUtils() throws IOException {
		super();
		
	}

public static void takesScreenShot(String name) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("C:\\Users\\INFOKOM\\eclipse-workspace\\selenium-testng-reports\\target\\" + name+ ".png"));
		
	}

public void WriteText(WebElement element , String  text ) {
	
	element.clear();
	element.sendKeys(text);
	
}

public void clickButton(WebElement element) {
	
	
	element.click();
}

public void selectDropDownListByValue(WebElement element, String value) {
	Select dropDownList = new Select(element);
	dropDownList.selectByValue(value);
}

}
