package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
					glue = {"stepsdefinitions","hooks"},
					plugin = {
								"html:reports/Opencart-reports.html",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								"pretty"
								//"rerun:target/rerun.txt"
							},
					dryRun = false,
					monochrome = true,
					publish = true,
					//features = {"src/test/java/features/registration.feature"}
					//features = {"src/test/java/features/"},
					//features = {"src/test/java/features/login.feature"},
					//features = {"src/test/java/features/login.feature", "src/test/java/features/login2.feature"},
					//features = {"src/test/java/features/loginDDTExcel.feature"},
					//features = {"src/test/java/features/login2.feature"},
					features = {"src/test/java/features/login2.feature"}
					//features = {"@target/rerun.txt"},
					//tags = "@sanity"
					//tags = "@regression"
					//tags = "@sanity and @regression"
					//tags = "@sanity or @regression"
					//tags = "@sanity and not @regression"
					//tags = "@regression and not @sanity"
		)
public class RunnerClass extends AbstractTestNGCucumberTests{

}
