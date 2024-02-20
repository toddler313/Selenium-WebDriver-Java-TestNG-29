package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_02_Selenium_Locator {

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
        driver.get("https://demo.nopcommerce.com/register");
    }

    //TestNG orders TCs according to Alphanumeric

    @Test
    public void TC_01_ID() {

        WebElement fName = driver.findElement(By.id("FirstName"));
        fName.sendKeys("Brian Ng.");
    }

    @Test
    public void TC_02_Class() {

    }

    @Test
    public void TC_03_Name() {

    }

    @Test
    public void TC_04_TagName() {

    }

    @Test
    public void TC_05_LinkText() {
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_PartialLinkText() {
        driver.findElement(By.partialLinkText("Recently"));
    }

    @Test
    public void TC_07_CSS_Locator() {
        driver.findElement(By.cssSelector("input[id='Company']"));
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));

        // Similar to class
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector(".page-title"));

        // CSS vs Name
        driver.findElement(By.cssSelector("input[name='Email']"));

        // CSS vs TagName
        driver.findElement(By.cssSelector("input"));

        // CSS vs LinkText
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        // CSS vs PartialLinkText
        driver.findElement(By.cssSelector("a[href*='address']"));  // in the middle
        driver.findElement(By.cssSelector("a[href^='/customer/ad']"));  // in the begin
        driver.findElement(By.cssSelector("a[href$='sses']"));  // in the end
    }

    @Test
    public void TC_08_XPath() {
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        driver.findElement(By.xpath("//*[@name='DateOfBirthMonth']"));

        driver.findElement(By.xpath("//input[@id='Password']"));


        //Link Text
        driver.findElement(By.xpath("//a[text()='Recently viewed products']"));

        // Partial Link Text
        driver.findElement(By.xpath("//a[contains(text(),'viewed products')]"));
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

}
