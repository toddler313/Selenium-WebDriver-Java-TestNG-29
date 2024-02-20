package testNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import testNG.tiki.admin.BaseTest;

public class TC06_B_Parameters_Optional_MultiBrowsers_MultiEnv extends BaseTest {
    By emailTextbox = By.xpath("//input[@id='email']");
    By passwordTextbox = By.xpath("//input[@id='pass']");
    By loginButton = By.xpath("//button[@id='send2']");

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("=== Init From Parameters ===");
    }

    /*
        @Optional("value") : we use this annotation as a backup if we want to run tests right on the class
        Not via the XML configuration file.
        This time, TestNG doesn't know about the Parameters from the XML
        => say something to coordinate appropriately
     */

    @Parameters("testEnvironment")
    @Test
    public void TC_01_LoginToSystem(@Optional("live") String environmentValue) {
        String envUrl = getEnvironmentValue(environmentValue);
        driver.get(envUrl + "/index.php/customer/account/login/");
        System.out.println(envUrl + "/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(passwordTextbox).sendKeys("111111");
        driver.findElement(loginButton).click();

        String displayedUsername = driver.findElement(By.cssSelector(".col-1 p")).getText();
        Assert.assertTrue(displayedUsername.contains("selenium_11_01@gmail.com"));

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("=== Clean Up Parameters ===");
    }

}
