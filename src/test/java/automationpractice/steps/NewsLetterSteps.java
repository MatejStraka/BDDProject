package automationpractice.steps;

import automationpractice.DriverFactory;
import automationpractice.pages.NewsLetterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import static org.hamcrest.MatcherAssert.assertThat;

public class NewsLetterSteps extends DriverFactory {

    private final NewsLetterPage newsLetterPage = new NewsLetterPage(driver);

    @Given("^User is on the automationpractice page$")
    private void user_Is_On_AutomationPractise_Page() {
        newsLetterPage.openAutomationPractisePage();
    }

    @When("^I fill the newsletter email: \"([^\"]*)\"$")
    public void iFillNewsletterEmail(String email) {
        newsLetterPage.getNewsletterField().sendKeys(email);
    }

    @And("^I click the subscribe button$")
    public void iClickSubscribeButton() {
        newsLetterPage.getNewsletterField().sendKeys(Keys.ENTER);
    }

    @Then("^There is an error info: \"([^\"]*)\"$")
    public void thereIsAnErrorInfo(String message) {
        assertThat("User should see error message during subscribing",
                newsLetterPage.getSubscribeErrorStatus().getText().contains(message));
    }

    @Then("^There is a success info: \"([^\"]*)\"$")
    public void thereIsASuccessInfo(String message) {
        assertThat("User should see success message after subscribing",
                newsLetterPage.getSubscribeSuccessStatus().getText().contains(message));
    }

    @When("^I fill the generated newsletter email: \"([^\"]*)\"$")
    public void iFillGeneratedNewsletterEmail(String domain) {
        String email = System.currentTimeMillis() + domain;
        newsLetterPage.getNewsletterField().sendKeys(email);
    }
}
