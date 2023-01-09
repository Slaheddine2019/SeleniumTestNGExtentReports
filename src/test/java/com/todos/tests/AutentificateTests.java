package com.todos.tests;



import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.todos.pages.AuthentificationPage;
import com.todos.utils.CommandsUtils;
import com.todos.utils.Setup;
import com.todos.utils.Wait;

public class AutentificateTests extends Setup {

	 
	public AutentificateTests() throws IOException {
		
		super();

	}

	AuthentificationPage authentificationPage;
	CommandsUtils commands;
	Wait wait;

	@Test(priority = 2)
	public void loginWithValidCredentiels() throws IOException {

		authentificationPage = new AuthentificationPage();
		commands = new CommandsUtils();
		commands.WriteText(AuthentificationPage.username, prop.getProperty("valid.home.login"));
		commands.WriteText(AuthentificationPage.password, prop.getProperty("valid.home.password"));
		commands.clickButton(AuthentificationPage.LoginButton);
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualUrl, expectedUrl);
		
	}

	@Test(dataProvider = "getData", priority = 1)
	public void loginWithInValidCredentiels(String username, String password) throws IOException {

		authentificationPage = new AuthentificationPage();
		commands = new CommandsUtils();
		commands.WriteText(AuthentificationPage.username, username);
		commands.WriteText(AuthentificationPage.password, password);
		commands.clickButton(AuthentificationPage.LoginButton);
		String expectedMessageError = "Epic sadface: Username and password do not match any user in this service";
	    String actualMessageError = AuthentificationPage.textErrorMessage.getText();
		Assert.assertEquals(actualMessageError,expectedMessageError);
		
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[3][2];

		data[0][0] = "standard_user";
		data[0][1] = "123456";

		data[1][0] = "123456";
		data[1][1] = "secret_sauce";

		data[2][0] = "123456";
		data[2][1] = "secret_sauce";

		return data;

	}

}
