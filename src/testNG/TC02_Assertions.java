package testNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TC02_Assertions {

    /*
        MOSTLY ASSERTIONS USED:
        * Assert.assertTrue()
        * Assert.assertFalse()
        * Assert.assertEquals()

     */

    public WebDriver driver;

    @Test
    public void TC_01() {
//        driver.navigate().to("http://live.techpanda.org/index.php/");
//        String homePageTitle = driver.getTitle();
//        Assert.assertEquals(homePageTitle, "Home page");
        System.out.println("==============Assert True==============");
//        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());


        System.out.println("==============Assert False==============");
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='checkbox'][@value='female']")).isSelected());


        System.out.println("==============Assert ABSOLUTE Equals==============");
//        Assert.assertEquals(driver.findElement(By.cssSelector("div#search")).getAttribute("placeholder"), "Search entire store here...");
//        Assert.assertEquals(driver.findElement(By.xpath("advice-required-entry-email")).getText(), "This is a required field.");


        System.out.println("==============Assert RELATIVE Equals==============");
//        String benefitText = driver.findElement(By.cssSelector("ul.benefits")).getText();
//        Assert.assertTrue(benefitText.contains("Faster Checkout"));
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @Test
    public void TC_02() {
//        driver.navigate().to("http://live.techpanda.org/index.php/");
//        String homePageTitle = driver.getTitle();
//        Assert.assertEquals(homePageTitle, "Home page");
        System.out.println("TC_02 of Class 02");
    }

    @Test
    public void TC_03() {
//        driver.navigate().to("http://live.techpanda.org/index.php/");
//        String homePageTitle = driver.getTitle();
//        Assert.assertEquals(homePageTitle, "Home page");
        System.out.println("TC_03 of Class 02");
    }
}
