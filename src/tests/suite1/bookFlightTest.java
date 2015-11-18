package tests.suite1;

import java.io.IOException;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.beust.jcommander.Parameters;

import tests.testBase;

//Step 1
@RunWith(Parameterized.class)

public class bookFlightTest extends testBase {

	// Declare the variables
	public String tripType;
	

	public bookFlightTest(String tripType) {
		this.tripType = tripType;
	}
	
	@Parameters
	public Collection<Object[]> fetchData()
	{}

	@Before
	public void beforeTest() throws IOException {
		initilaise();
	}

	
	@Test
	public void findFlight() {

		driver.get(CONFIG.getProperty("testURL"));
		System.out.println("Select default values");

		getObjectbyXpath("tripType_Radio_button").sendKeys(tripType);
		getObjectbyXpath("findFlightContinue_button").click();
		getObjectbyXpath("selectFlightContinue_button").click();
		getObjectbyXpath("securePurchase_button").click();

		// Verify the success message
		String successMessage = getObjectbyXpath("successBooked_text").getText();

		// thkYou =
		// driver.findElement(By.xpath(CONFIG.getProperty("registration_success_text")));

		System.out.println("Flight booked successfully " + successMessage);

		String confirmationNumber = getObjectbyXpath("flightConfirmation_text").getText();
		System.out.println("Confirmation Number is " + confirmationNumber);

	}

	

}
