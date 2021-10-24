package automationpractice.steps;

import automationpractice.BankAccount;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BankAccountSteps {

    private boolean isWithdrawPossible;
    private BankAccount bankAccount;

    @Before
    public void setUpScenario() {
        isWithdrawPossible = false;
    }

    @After
    public void tearDownScenario() {
        isWithdrawPossible = true;
    }

    @Given("Bank account with {int} GBP")
    public void bankAccountWithGBP(int accountBalance) {
        bankAccount = new BankAccount(accountBalance);
    }

    @When("A user withdraw {int} GBP")
    public void aUserWithdraw$(int withdraw) {
        isWithdrawPossible = bankAccount.withdraw(withdraw);
    }

    @Then("the withdraw operation should not be possible")
    public void theWithdrawOperationShouldNotBePossible() {
        Assert.assertFalse(isWithdrawPossible);
    }

    @Then("the withdraw operation should be possible")
    public void theWithdrawOperationShouldBePossible() {
        Assert.assertTrue(isWithdrawPossible);
    }

    @And("The account balance should be {int} GBP")
    public void theAccountBalanceShouldBe$(int accountBalance) {
        Assert.assertEquals(accountBalance, bankAccount.getAccountBalance());
    }

    @And("A user transfer {int} GBP")
    public void aUserTransferGBP(int money) {
        bankAccount.transfer(money);
    }
}
