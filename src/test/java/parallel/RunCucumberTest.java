/**
 * 
 */
package parallel;


import org.testng.annotations.DataProvider;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * 
 */

@CucumberOptions(features = {"src\\test\\resources\\parallel"},
                  glue = {"parallel"},
                  plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                 		 ,"html:reports/cucumber-report.html","json:reports/cucumber-report.json",
                 		 "timeline:test-output-thread/"})
public class RunCucumberTest extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}
}
