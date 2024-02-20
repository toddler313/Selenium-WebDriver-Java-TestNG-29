package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_XPath_CSS_3 {

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

    }

    @Test
    public void TC_01() {
        driver.get("https://automationfc.github.io/basic-form/");

        // Check Visualization of a text
        driver.findElement(By.xpath("//h1[text()='Selenium WebDriver API']")).isDisplayed();

        String hello = driver.findElement(By.id("nested")).getText();
        System.out.println(hello);

        // 1- Limit usage on Relative
        driver.findElement(By.xpath("//p[contains(text(),\"Mail Personal or Business Check, Cashier's Check or money order to:\")]")).isDisplayed();

        // 2- Get Text then verify - in case there are multiple <p> inside a <h5>
        String p1 = driver.findElement(By.xpath("//h5[@id='nine']/p[1]")).getText();
        Assert.assertTrue(p1.contains("Mail Personal or Business Check, Cashier's Check or money order to:"));
        Assert.assertTrue(p1.contains("Mail Personal or Business Check"));
        Assert.assertTrue(p1.contains("Cashier's Check or money order to:"));

        // 3- Should not embed a whole text into locator, rather getText() then assertEquals
        String nestedText = driver.findElement(By.xpath("//h5[@id='nested']")).getText();
        System.out.println(nestedText);
        Assert.assertEquals(nestedText,"Hello World! (Ignore Me) @04:45 PM");
    }

    @Test
    public void TC_02() {
        driver.get("https://automationfc.github.io/basic-form/");
        // Using concat() if text contains both ' and "
        // Hello "John", What's happened?
        String concatText = driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]")).getText();
        Assert.assertEquals(concatText, "Hello \"John\", What's happened?");

        // But should not inject whole text into xpath, take advantage of attributes
        concatText = driver.findElement(By.xpath("//span[@class='concat']")).getText();

    }

//    @Test
    public void TC_03() {

        // and or
        driver.findElement(By.xpath("//input[@type='email' and @id='email' and @title='Email Address']"));

        // not
        driver.findElement(By.xpath("//input[not(@type='text')]"));
        driver.findElement(By.xpath("//div[not(@style='display:none;')]/div[@class='className']"));
    }

//    @Test
    public void TC_04() {
        //Substring(str, start, len)
        driver.get("https://automationfc.github.io/basic-form/");
        String nestedText = driver.findElement(By.xpath("//h5[@id='nested']")).getText();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
