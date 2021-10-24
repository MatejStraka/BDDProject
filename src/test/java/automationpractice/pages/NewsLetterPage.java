package automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class NewsLetterPage {

    private static final String AUTOMATION_PRACTISE_URL = "http://automationpractice.com/";
    private final WebDriver driver;

    @FindBy(how = How.ID, using = "newsletter-input")
    private WebElement newsletterField;

    @FindBy(how = How.CLASS_NAME, using = "alert-danger")
    private WebElement subscribeErrorStatus;

    @FindBy(how = How.CLASS_NAME, using = "alert-success")
    private WebElement subscribeSuccessStatus;


    public NewsLetterPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAutomationPractisePage() {
        driver.get(AUTOMATION_PRACTISE_URL);
    }

    public WebElement getNewsletterField() {
        return newsletterField;
    }

    public WebElement getSubscribeErrorStatus() {
        return subscribeErrorStatus;
    }

    public WebElement getSubscribeSuccessStatus() {
        return subscribeSuccessStatus;
    }
}