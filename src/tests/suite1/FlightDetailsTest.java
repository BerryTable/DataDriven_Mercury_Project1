package tests.suite1;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import tests.testBase;
import util.testUtil;

public class FlightDetailsTest extends testBase {

	@Before
	public void beforeTest() throws IOException {
		initilaise();
	}

	@Test
	public void logintTest() {
		driver.get(CONFIG.getProperty("testURL"));
		driver.manage().window().maximize();
		testUtil.doLogin("quicktest", "Pass@123");
	}

	@Test
	public void flightDetails() throws Exception {

		getObjectbyXpath("tripType_radio_button").sendKeys("oneway");

		// Set dropdown values
		getObjectbyXpath("passenger_count_dropdown").sendKeys("3");
		getObjectbyXpath("departingFrom_dropdown").sendKeys("London");
		getObjectbyXpath("departingOnMonth_dropdown").sendKeys("May");
		getObjectbyXpath("departingOnDay_dropdown").sendKeys("4");
		getObjectbyXpath("arrivingToPort_dropdown").sendKeys("Frakfurt");
		getObjectbyXpath("arrivingOnMonth_dropdown").sendKeys("June");
		getObjectbyXpath("arrivingOnDay_dropdown").sendKeys("7");
		getObjectbyXpath("airline_dropdown").sendKeys("Unified Airlines");
		getObjectbyXpath("serviceclass_radio_button").sendKeys("First");

		// Click on Continue button
		getObjectbyXpath("flightFinderContinue_button").click();
		getObjectbyXpath("selectFlightContinue_button").click();
		getObjectbyXpath("securePurchase_button").click();

		// Sign out and close the browser
//		getObjectbyXpath("signout_link").click();
//		driver.close();

	}

}
