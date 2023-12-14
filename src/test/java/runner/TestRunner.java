package runner;

import Base.TestBase;
import cucumber.api.CucumberOptions;


@CucumberOptions(features = "src/test/java/features/End2End_Tests.feature"
        , glue = {"steps"}
        , plugin = {"pretty", "html:target/cucumber-html-report"})
public class TestRunner extends TestBase {

}
