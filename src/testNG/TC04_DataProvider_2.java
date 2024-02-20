package testNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNG.tiki.admin.BaseTest;

import java.lang.reflect.Method;

public class TC04_DataProvider_2 extends BaseTest {

    By emailTextbox = By.xpath("//input[@id='email']");
    By passwordTextbox = By.xpath("//input[@id='pass']");
    By loginButton = By.xpath("//button[@id='send2']");

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("=== Init From DataProvider ===");
    }


    /*
        THIS APPROACH IS RARELY USED.
        SO JUST FOR FUN REFERENCE
     */


    @Test(dataProvider = "loginData")
    public void TC_01_LoginToSystem(String username, String password) {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();

        String displayedUsername = driver.findElement(By.cssSelector(".col-1 p")).getText();
        Assert.assertTrue(displayedUsername.contains(username));

        // ... Need to log out to start another round of testing with new data
        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
    }

    @Test(dataProvider = "loginData")
    public void TC_02_LoginToSystem(String username, String password) {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();

        String displayedUsername = driver.findElement(By.cssSelector(".col-1 p")).getText();
        Assert.assertTrue(displayedUsername.contains(username));

        // ... Need to log out to start another round of testing with new data
        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
    }

    @Test(dataProvider = "loginData")
    public void TC_03_LoginToSystem(String username, String password) {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();

        String displayedUsername = driver.findElement(By.cssSelector(".col-1 p")).getText();
        Assert.assertTrue(displayedUsername.contains(username));

        // ... Need to log out to start another round of testing with new data
        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
    }

    @DataProvider(name = "loginData")
    public static Object[][] loginData(Method method) {

        Object[][] result = null;

        /*
            SWITCH CASE CAN ALSO BE USED

         */

        if (method.getName().contains("TC_01")) {
            result = new Object[][] {
                {"selenium_11_01@gmail.com", "111111"}
            };
        } else if (method.getName().contains("TC_02")) {
            result = new Object[][] {
                {"selenium_11_02@gmail.com", "111111"}
            };
        } else {
            result = new Object[][]{
                {"selenium_11_03@gmail.com", "111111"}
            };
        }
        return result;
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("=== Clean Up Data Provider ===");
    }

}
