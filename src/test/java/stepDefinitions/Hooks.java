package stepDefinitions;

import io.cucumber.java.After;
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
}