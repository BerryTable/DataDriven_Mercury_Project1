package tests.suite1;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import tests.testBase;
import util.testUtil;

public class LoginTest extends testBase

{

	@Before
	public void beforeTest() throws IOException {
		initilaise();
	}

	@Test
	public void logintTest() {
		driver.get(CONFIG.getProperty("testURL"));
		testUtil.doLogin("quicktest", "Pass@123");

		if (getObjectbyXpath("passenger_count_dropdown").isDisplayed()) {
			isLoggedIn = true;
			System.out.println("Im IN successfully " + isLoggedIn);
		}

		else {
			isLoggedIn = false;
			System.out.println(isLoggedIn);
		}

	}
}
