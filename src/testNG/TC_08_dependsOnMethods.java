package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testNG.tiki.admin.BaseTest;

import java.time.Duration;

public class TC_08_dependsOnMethods extends BaseTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Generate Test Data on Dependencies...");
    }

    @Test
    public void TC_01() {
        System.out.println("TC_01");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "TC_01")
    public void TC_02() {
        System.out.println("TC_02");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "TC_02")
    public void TC_03() {
        System.out.println("TC_03");
    }

    @Test(dependsOnMethods = "TC_03")
    public void TC_04() {
        System.out.println("TC_04");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Clean Up Data on Dependencies");
    }

}
