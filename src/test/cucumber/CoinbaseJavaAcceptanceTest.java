

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(tags = { "@CLIENT_OPERATIONS" }, monochrome = true, format = {"pretty", "html:target/cucumber", "junit:target/junit.xml", "json-pretty:target/cucumber-report-pretty.json", "json:target/cucumber-report.json"})
//@Cucumber.Options(tags = { "@WIP" }, monochrome = true, format = {"pretty", "html:target/cucumber", "junit:target/junit.xml", "json-pretty:target/cucumber-report-pretty.json", "json:target/cucumber-report.json"})
// NOTES:
// 	1) To only run UI tests add "tags = { "@UI" }, " into Cucumber.Options
//  2) To only run API tests add "tags = { "@API" }, " into Cucumber.Options
//  3) To run UI tests requiring setup, use:  tags = { "@WIP_UI, @SETUP"}
//	4) To run all tests remove the "tags" argument
// 
// example of a "not" tag => tags = { "~@WIP" }
// can use -Dcucumber.options="--format {\"pretty\", \"html:target/cucumber\", \"junit:target/junit.xml\"} --glue classpath:com/savvis src/test/resources"
public class CoinbaseJavaAcceptanceTest {
	public CoinbaseJavaAcceptanceTest() {
	}

	@BeforeClass
	public static void setup() {
	}

	@AfterClass
	public static void teardown() {
		// stop the Selenium web driver
		//WebDriverController.getInstance().stopDriver();
	}
}
