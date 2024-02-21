package testNG;

import listener.ExtendReportListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import testNG.testData.DataGeneration;
import testNG.tiki.admin.BaseTest;

import java.time.Duration;

@Listeners(ExtendReportListener.class)
public class TC09_Listener_ITestListener extends BaseTest {

    By fNameLocator = By.xpath("//input[@id='firstname']");
    By lNameLocator = By.xpath("//input[@id='lastname']");
    By emailLocator = By.xpath("//input[@id='email_address']");
    By passwordLocator = By.xpath("//input[@id='password']");
    By cPasswordLocator = By.xpath("//input[@id='confirmation']");
    By registerBtnLocator = By.cssSelector("button[title='Register']");
    By welcomeMessageLocator = By.cssSelector("p.hello strong");
    By myAccountHeaderLocator = By.cssSelector("div#header-account a[title='My Account']");
    WebDriverWait explicitWait;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("=== Init From Parameters ===");
    }

    /*
        invocationCount = n : repeat the TC for n times

     */

    @Parameters("testEnvironment")
    @Test
    public void TC_01_RegisterNewUser(@Optional("live") String environmentValue) {
        String envUrl = getEnvironmentValue(environmentValue);
        driver.get(envUrl + "/index.php/customer/account/create/");
        System.out.println(envUrl + "index.php/customer/account/create/");

        String fName = DataGeneration.randomWords(5);
        String lName = DataGeneration.randomWords(5);
        String email = DataGeneration.randomEmailWithGivenDomain("example.com");
        String password = DataGeneration.randomWords(7);

        driver.findElement(fNameLocator).sendKeys(fName);
        driver.findElement(lNameLocator).sendKeys(lName);
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(cPasswordLocator).sendKeys(password);
        driver.findElement(registerBtnLocator).click();

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(myAccountHeaderLocator).click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessageLocator));
//        Assert.assertTrue(driver.findElement(welcomeMessageLocator).getText().contains(fName));
        Assert.assertTrue(driver.findElement(welcomeMessageLocator).getText().equals("abc"));   //Set Failure here to configure ITestListener taking screenshot

        String details = driver.findElement(By.cssSelector(".col-1 p")).getText();
        Assert.assertTrue(details.contains(email));

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();

        System.out.println(fName + " " + lName + " " + email + " " + password);
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("=== Clean Up Parameters ===");
    }

}
