package testNG;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TC01_Annotations {

    public WebDriver driver;





    @Test
    public void TC_01() {
//        driver.navigate().to("http://live.techpanda.org/index.php/");
//        String homePageTitle = driver.getTitle();
//        Assert.assertEquals(homePageTitle, "Home page");
        System.out.println("TC_01 of Class 01");
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
//        driver.get("http://live.techpanda.org/index.php/");
//        String homePageTitle = driver.getTitle();
//        Assert.assertEquals(homePageTitle, "Home page");
        System.out.println("TC_02 of Class 01");
    }

    @Test
    public void TC_03() {
//        driver.get("http://live.techpanda.org/index.php/");
//        String homePageTitle = driver.getTitle();
//        Assert.assertEquals(homePageTitle, "Home page");
        System.out.println("TC_03 of Class 01");
    }

}
