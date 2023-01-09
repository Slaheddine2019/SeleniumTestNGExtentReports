package com.todos.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.todos.utils.BasePage;
import com.todos.utils.Wait;

public class AuthentificationPage extends BasePage {
	
	public Wait wait;

	public AuthentificationPage() throws IOException {

		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	final static String  USERNAME_FILL = "//input[@id='user-name']";
	final static String  PASSWORD_FILL = "//input[@id='password']";
	final static String  LOGIN_BUTTON =  "//input[@id='login-button']";
	final static  String ACTUAL_TEXT_ERRORMESSAGE = "//div[@class='error-message-container error']";
	
	
	

	@FindBy(how = How.XPATH, using = USERNAME_FILL )
	public static WebElement username;

	@FindBy(how = How.XPATH, using = PASSWORD_FILL)
	public static WebElement password;

	@FindBy(how = How.XPATH, using = LOGIN_BUTTON)
	public static WebElement LoginButton;

	@FindBy(how = How.XPATH, using = ACTUAL_TEXT_ERRORMESSAGE )
	public static WebElement textErrorMessage;
	

	@FindBy(how = How.XPATH, using = "//div[@class='app_logo']")
	public static WebElement logoSwagLaps;

	
}
