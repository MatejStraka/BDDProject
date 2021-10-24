package automationpractice.steps;


import automationpractice.Calculator;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CalculatorStepDefs {

    private String exceptionMessage;
    private float result;
    private Calculator calculator;

    @After
    public void afterScenario(Scenario scenario) {
        calculator = null;
    }

    @After("@success and not @fail")
    public void afterSuccessScenario(Scenario scenario) {
        result = 0;
    }

    @After("@fail and not @success")
    public void beforeFailScenario(Scenario scenario) {
        exceptionMessage = null;
    }

    @Given("I have a calculator")
    public void iHaveACalculator() {
        calculator = new Calculator();
    }

    @When("I divide {int} by {int}")
    public void iDivideBy(int arg0, int arg1) {
        try {
            result = calculator.divide(arg0, arg1);
        } catch (Exception e) {
            exceptionMessage = e.getMessage();
        }
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int arg0) {
        Assert.assertEquals(result, arg0, 0);
    }

    @Then("the error message should be {string}")
    public void theErrorMessageShouldBe(String arg0) {
        Assert.assertEquals(exceptionMessage, arg0);
    }
}
