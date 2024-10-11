package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/resource/features",
        tags = "@login",
        glue = {"utility", "StepDefinition" }, monochrome = true,
        plugin = { "pretty", "html:target/cucumber-html-report", "json:cucumber.json" }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {return super.scenarios();}

    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper){
        super.runScenario(pickleWrapper,featureWrapper);
    }

}
