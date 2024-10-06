package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
					glue = {"stepsdefinitions","hooks"},
					plugin = {
								"html:reports/Opencart-reports.html",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								//"pretty"
								//"rerun:target/rerun.txt"
							},
					dryRun = false,
					monochrome = true,
					publish = true,
					//features = {"src/test/java/features/"}
					//features = {"src/test/java/features/registration.feature"}
					//features = {"src/test/java/features/login_1.feature"}
					features = {"src/test/java/features/login_2.feature"}
					//features = {"src/test/java/features/login_DDT.feature"}
					//features = {"src/test/java/features/login_1.feature", "src/test/java/features/login_2.feature"}
					//features = {"@target/rerun.txt"}
					//tags = "@Sanity"
					//tags = "@Regression"
					//tags = "@Sanity and @Regression"
					//tags = "@Sanity or @Regression"
					//tags = "@Sanity and not @Regression"
					//tags = "@Regression and not @Sanity"
		)
public class RunnerClass extends AbstractTestNGCucumberTests{

}
