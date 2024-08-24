package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	//features = {".//features/"},
					//features = {".//features/login.feature"}
					//features = {".//features/login.feature", ".//features/login2.features"}
					//features = {"@target/rerun.txt"}
					//features = {".//features/loginDDTExcel.feature"},
					features = {".//features/login2.feature"},
					//features = {".//features/registration.feature"}, 
					glue={"stepsdefinitions","hooks"},
					plugin= {
							"pretty", "html:reports/myreports.html",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							//"rerun:target/rerun.txt"
					},
					dryRun=false,
					monochrome=true,
					publish=true,
					//tags="@sanity"
					//tags="@regression"
					//tags="@sanity and @regression"
					//tags="@sanity and not @regression"
					//tags="@sanity or @regression"
					tags="@regression and not @sanity"
		)
public class TestRun {

}
