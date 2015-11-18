package util;

import tests.testBase;

public class testUtil extends testBase {

	public static void doLogin(String userName, String userPassword) {
		if (isLoggedIn) {
			return;
		}
		getObjectbyXpath("userName_input").sendKeys(userName);
		getObjectbyXpath("userPassword_input").sendKeys(userPassword);
		getObjectbyXpath("submitButton_button").click();
	}

}
