package automationpractice.steps;


import automationpractice.DriverFactory;
import automationpractice.pages.ClothesBrowserPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;

public class ClothesBrowserSteps extends DriverFactory {

    private final ClothesBrowserPage clothesBrowserPage = new ClothesBrowserPage(driver);

    @Given("^User is on the automationpractice page$")
    public void user_Is_On_AutomationPractise_Page() {
        clothesBrowserPage.openAutomationPractisePage();
    }

    @When("^I click the \"([^\"]*)\" button$")
    public void iClickButton(String category) {
        clothesBrowserPage.getCategory(category).click();
    }

    @Then("^I can see the \"([^\"]*)\" page header$")
    public void iCanSeePageHeader(String header) throws InterruptedException {
        Thread.sleep(5000);
        String headerText = clothesBrowserPage.getCategoryHeader().getText().trim();
        assertThat(String.format("Page header should have text %s", header),
                header.equalsIgnoreCase(headerText));
    }
}
