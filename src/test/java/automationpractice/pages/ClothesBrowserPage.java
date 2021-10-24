package automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ClothesBrowserPage {

    private static final String AUTOMATION_PRACTISE_URL = "http://automationpractice.com/";
    private final WebDriver driver;

    @FindBy(how = How.CLASS_NAME, using = "cat-name")
    private WebElement categoryHeader;

    public ClothesBrowserPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAutomationPractisePage() {
        driver.get(AUTOMATION_PRACTISE_URL);
    }

    public WebElement getCategory(String category) {
        List<WebElement> listItems = driver.findElements(By.xpath("//div[@id='block_top_menu']/ul/li"));
        for (WebElement listItem : listItems) {
            WebElement link = listItem.findElement(By.tagName("a"));
            if (link.getText().equalsIgnoreCase(category)) {
                return link;
            }
        }
        return null;
    }

    public WebElement getCategoryHeader() {
        return categoryHeader;
    }
}
