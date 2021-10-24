package automationpractice.steps;

import automationpractice.DriverFactory;
import automationpractice.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchSteps extends DriverFactory {

    private final SearchPage searchPage = new SearchPage(driver);

    @Given("^User is on the automationpractice page$")
    private void user_Is_On_AutomationPractise_Page() {
        searchPage.openAutomationPractisePage();
    }

    @When("^I fill the search field in the search form with text: \"([^\"]*)\"$")
    public void iFillSearchFieldInSearchFormWithText(String searchText) throws Throwable {
        searchPage.getSearchForm().sendKeys(searchText);
    }

    @And("^I click the search button$")
    public void iClickSearchButton() {
        searchPage.getSearchForm().sendKeys(Keys.ENTER);
    }

    @Then("^There is an info: \"([^\"]*)\"$")
    public void thereIsAnInfo(String searchResult) {
        assertThat("User should see search result message", searchPage.getSearchMessageText().contains(searchResult));
    }

    @Then("^\"([^\"]*)\" items were found$")
    public void itemsWereFound(String numberOfItems) {
        assertThat("User should see search number of found elements",
                searchPage.getSearchResultsCounter().getText().contains(numberOfItems));
    }
}
