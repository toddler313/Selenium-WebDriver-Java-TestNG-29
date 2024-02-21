package testNG.tiki.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    private final String projectPath = System.getProperty("user.dir");
    private final String osName = System.getProperty("os.name");

    /*
        @Optional("value") : we use this annotation as a backup if we want to run tests right on the class
        Not via the XML configuration file.
        This time, TestNG doesn't know about the Parameters from the XML
        => say something to coordinate appropriately
     */

    @Parameters("testBrowser")
    @BeforeTest(alwaysRun = true)
    public void browserInit(@Optional("firefox") String browserValue) {
        if (osName.contains("Windows")) {
            switch (browserValue) {
                case "chrome":
                    System.setProperty("testNG.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                    System.out.println("Initializing Chrome browser...");
                    break;
                case "firefox":
                    System.setProperty("testNG.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    System.out.println("Initializing Firefox browser...");
                    break;
                case "edge":
                    System.setProperty("testNG.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    System.out.println("Initializing MS Edge browser...");
                    break;
                default:
                    System.out.println("No suitable value found for browser. Please check your XML configurations on Parameters.");
                    break;
            }
        } else {
            System.setProperty("testNG.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    protected String getEnvironmentValue(String environmentValue) {
        switch (environmentValue) {
            case "dev":
                return "http://dev.techpanda.org";
            case "test":
                return "http://test.techpanda.org";
            case "live":
                return "http://live.techpanda.org";
            case "production":
                return "http://demo.techpanda.org";
            default:
                return null;
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @AfterTest(alwaysRun = true)
    public void cleanBrowser() {
        System.out.println("Clean Up browser");
        driver.quit();
    }
}
