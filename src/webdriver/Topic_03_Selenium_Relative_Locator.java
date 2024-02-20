package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_03_Selenium_Relative_Locator {

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
//        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/login");
    }

    @Test
    public void TC_01() {
        By loginBtnLocator = By.cssSelector(".button-1.login-button");
        WebElement loginBtn = driver.findElement(loginBtnLocator);

        // THE MORE REFERENCES TO SURROUNDING ELEMENTS, THE MORE PRECISE TO THE LOCATION OF THE EXPECTED ELEMENT
        // This is a way to test GUI, location and position

        By rememberMeCheckboxLocator = By.id("RememberMe");

        By forgotPasswordLinkLocator = By.cssSelector("span.forgot-password");

        By passwordTextfieldLocator = By.id("Password");


        // This returns a relative locator of the expected element.
        By rememberMeLabelRelativeLocator = RelativeLocator.with(By.tagName("label"))
                .above(loginBtnLocator)     //above(loginBtn)       above() can take on a locator or a web Element
                .toRightOf(rememberMeCheckboxLocator)
                .near(forgotPasswordLinkLocator)
                .below(passwordTextfieldLocator);               //toRightOf() can take on a locator or a web element

        WebElement rememberMeLabel = driver.findElement(rememberMeLabelRelativeLocator);
        Assert.assertEquals("Remember me?",rememberMeLabel.getText());
    }

    @Test
    public void TC_02() {
        List<WebElement> aTags = driver.findElements(RelativeLocator.with(By.tagName("a")));
        System.out.println("Number of <a> tag: " + aTags.size());
    }

    @Test
    public void TC_03() {

    }

    @Test
    public void TC_04() {

    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

}
