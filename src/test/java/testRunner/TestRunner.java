package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	plugin = {
								//"pretty",
								"html:html-report/Opencart-HtmlReport.html",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								"rerun:failed-scenario/failedScenario.txt"
							},
					glue = {"stepDefinitions","hooks"},
					monochrome = true,
					publish = true,
					dryRun = false,
					//features = {"src/test/java/features/"}
					//features = {"src/test/java/features/registration.feature"}
					//features = {"src/test/java/features/login_1.feature"}
					//features = {"src/test/java/features/login_2.feature"}
					features = {"src/test/java/features/login_DDT.feature"}
					//features = {"src/test/java/features/login_1.feature", "src/test/java/features/login_2.feature"}
					//features = {"@target/rerun.txt"}
					//tags = "@Sanity"
					//tags = "@Regression"
					//tags = "@Sanity and @Regression"
					//tags = "@Sanity or @Regression"
					//tags = "@Sanity and not @Regression"
					//tags = "@Regression and not @Sanity"
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
