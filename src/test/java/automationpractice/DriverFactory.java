package automationpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    private static final String BROWSER_PROPERTY = "browser";
    private static final String FIREFOX_BROWSER = "firefox";
    private static final String CHROME_BROWSER = "chrome";
    private static final long IMPLICIT_WAIT_TIMEOUT = 5;
    private static final int SCRIPT_TIMEOUT = 5;
    protected static WebDriver driver;

    public static void startBrowser() {
        if (driver == null) {
            switch (getBrowser().toLowerCase()) {
                case FIREFOX_BROWSER:
                    driver = new FirefoxDriver();
                    break;
                case CHROME_BROWSER:
                    //TODO: replace with chrome webdriver path
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                default:
                    throw new IllegalStateException("Unsupported browser type");
            }

            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().fullscreen();

        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }

    }

    private static String getBrowser() {
        String browser = System.getProperty(BROWSER_PROPERTY);
        if (browser == null) {
            browser = System.getenv(BROWSER_PROPERTY);
            if (browser == null) {
                browser = CHROME_BROWSER;
            }
        }
        return browser;
    }

    public static void destroyDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

