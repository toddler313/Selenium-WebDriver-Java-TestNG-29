package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_XPath_CSS_2 {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
    }

    @Test
    public void TC_01() {
        // Locate My Account link text in header and footer
    }

    @Test
    public void TC_02() {
        // contains() can be used with both variable or function but remember to use comma "," instead of =
        //input[contains(@id, 'string')]
        //input[contains(text(), 'string')]
    }

    @Test
    public void TC_03() {
        // starts-with() can be used with both variable or function but remember to use comma "," instead of =
        //input[starts-with(@id, 'string')]
        //input[starts-with(text(), 'string')]
    }

    @Test
    public void TC_04() {
        //Xpath does not support ends-with()
        // But CSS supports $='string'
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
