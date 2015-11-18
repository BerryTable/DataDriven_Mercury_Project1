package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class testBase {

	// Read the property file

	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static WebDriver dr = null;
	public static EventFiringWebDriver driver = null;
	public static boolean isLoggedIn = false;

	public void initilaise() throws IOException {

		if (driver == null) {
			// Initialize config and OR file

			CONFIG = new Properties();
			FileInputStream fn = new FileInputStream(
					System.getProperty("user.dir") + "//src//config//config.properties");
			CONFIG.load(fn);

			OR = new Properties();
			fn = new FileInputStream(System.getProperty("user.dir") + "//src//config//OR.properties");
			OR.load(fn);

			// Initialize the webdriver
			if (CONFIG.getProperty("browserName").equals("IE")) {
				System.setProperty("webdriver.ie.driver", "C://SeleniumProjects//DD_Project1//NewSpace_SelProjects//Drivers//IEDriverServer.exe");
				dr = new InternetExplorerDriver();
			} else if (CONFIG.getProperty("browserName").equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "C://SeleniumProjects//DD_Project1//NewSpace_SelProjects//Drivers//chromedriver.exe");
				dr = new ChromeDriver();
			} else if (CONFIG.getProperty("browserName").equals("Firefox")) {				
				dr = new FirefoxDriver();
			} else {
				System.out.println("The named browser is not supported currently");
			}
			driver = new EventFiringWebDriver(dr);

		}

	}

	public static WebElement getObjectbyXpath(String xpathKey) {
		try {
			return driver.findElement(By.xpath(OR.getProperty(xpathKey)));
		}

		catch (Throwable t) { // report error
			System.out.println("Error in finding xpath, please retry !!!" + xpathKey);
			return null;
		}
	}

}
