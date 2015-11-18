package tests.suite1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FlightDetailsTest.class })
// @SuiteClasses({ LoginTest.class, FlightDetailsTest.class, Logout.class })

public class MyFirstSuite {

}
