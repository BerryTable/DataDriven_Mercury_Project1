package tests.suite1;

import org.junit.Test;
import tests.testBase;

public class Logout extends testBase {

	@Test
	public void doLogout() {
		if (isLoggedIn) {
			getObjectbyXpath("signout_link").click();
			isLoggedIn = false;
			driver.close();
			System.out.println("I'm Out successfully" + isLoggedIn);
		}
	}

}
