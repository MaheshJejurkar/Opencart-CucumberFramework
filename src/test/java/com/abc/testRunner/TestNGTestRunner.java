package com.abc.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.xml.XmlSuite;

@CucumberOptions(
        features = "classpath:features",
        tags = "@run",
        plugin = {
                "html:html-report/Opencart-HtmlReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:failed-scenario/failedScenario.txt"
        },
        glue = {"com/abc/stepDefinitions", "com/abc/hooks"},
        monochrome = true,
        publish = true,
        dryRun = false
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
        @DataProvider (parallel = false)
        @Override
        public Object[][] scenarios() {
                return super.scenarios();
        }

        @BeforeTest
        public void setUp(ITestContext context){
                XmlSuite suite = context.getSuite().getXmlSuite();
                suite.setParallel(XmlSuite.ParallelMode.TESTS);
                suite.setDataProviderThreadCount(2);
                suite.setThreadCount(2);
        }
}
