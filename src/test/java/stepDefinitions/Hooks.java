package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.TestContextSetup;

public class Hooks {
    private final TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void afterScenario() {
        testContextSetup.testBase.webDriverManager().close();
        testContextSetup.testBase.webDriverManager().quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] sourceFile = ((TakesScreenshot) testContextSetup.testBase.webDriverManager()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourceFile, "image/png", "image");
        }
    }
}