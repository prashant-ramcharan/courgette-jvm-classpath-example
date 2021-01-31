package courgette.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TestSteps {

    Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("I have a step")
    public void iHaveAStep() {
        scenario.log("I'm in the given step");
    }

    @When("I run the step")
    public void iRunTheStep() {
        scenario.log("I'm in the when step");
    }

    @Then("I verify the step was run")
    public void iVerifyTheStepWasRun() {
        scenario.log("I'm in the then step");
        Assert.assertTrue(true);
    }
}
