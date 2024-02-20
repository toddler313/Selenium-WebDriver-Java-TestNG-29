package testNG.tiki.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    private String osName = System.getProperty("os.name");

    @BeforeTest(alwaysRun = true)
    public void browserInit() {
        System.out.println("Open Firefox browser");
        if (osName.contains("Windows")) {
            System.setProperty("testNG.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("testNG.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterTest(alwaysRun = true)
    public void cleanBrowser() {
        System.out.println("Clean Firefox browser");
        driver.quit();
    }
}
