/**
 * 
 */
package testRunner;

import org.junit.runner.RunWith;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;  // This is for running feature files as JUNIT
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;   // This is for running feature files as TESTNG

/**
 * 
 */

@RunWith(Cucumber.class)   // This is for running feature files as JUNIT
@CucumberOptions(features = {"src\\test\\java\\featureFiles\\apiTest01.feature"},
//		                      "src\\test\\java\\featureFiles\\rentalCarAPI.feature"},
//		                      "src\\test\\java\\featureFiles\\apiTest03.feature"},
                 glue = "stepDefinitions",
                 monochrome = true,
                 dryRun = false,
                 plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                		 ,"html:reports/cucumber-report.html","json:reports/cucumber-report.json",
                		 "timeline:test-output-thread/"},
                 tags = "@DummyApi2 or @DummyApi1 or @API3 or @RentalCarAPI")
public class TestRunner{
	
	//extends AbstractTestNGCucumberTests
	
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		// TODO Auto-generated method stub
//		return super.scenarios();
//	}
	
//	@Test
//	void test() {
//		System.out.println("Running tests");
//	}

}
