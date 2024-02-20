package testNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import testNG.tiki.admin.BaseTest;

public class TC05_Parameters_MultiBrowsers extends BaseTest {

    By emailTextbox = By.xpath("//input[@id='email']");
    By passwordTextbox = By.xpath("//input[@id='pass']");
    By loginButton = By.xpath("//button[@id='send2']");

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("=== Init From Parameters ===");
    }

    @Test
    public void TC_01_LoginToSystem(String environmentValue) {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

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
