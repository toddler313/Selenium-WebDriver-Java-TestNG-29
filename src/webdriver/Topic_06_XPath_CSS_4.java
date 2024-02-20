package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_XPath_CSS_4 {

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
        driver.get("http://live.techpanda.org/index.php/mobile.html");

        // Using index - Caution: UI Change -> bamp! Rarely use
        WebElement img3 = driver.findElement(By.xpath("//ul[contains(@class,'products-grid')]/li[3]//img"));    //replace 1,2,3 to retrieve different img
        //Alternatively, if all blocks are the same in structure use ( ) to wrap up then place [n] at the end to browse exact item
        WebElement img2 = driver.findElement(By.xpath("(//a[@class='product-image']/img)[2]"));
    }

    @Test
    public void TC_02() {
        // position() same as index
        WebElement img2 = driver.findElement(By.xpath("//ul[contains(@class,'products-grid')]/li[position()=2]//img"));    //replace 1,2,3 to retrieve different img

        // last()
        WebElement lastImg = driver.findElement(By.xpath("//ul[contains(@class,'products-grid')]/li[last()]//img"));
    }

//    @Test
    public void TC_03() {
        driver.get("http://live.techpanda.org/index.php/mobile.html");
        //ancestor::
        //parent::
        //following-sibling::
        //preceding-sibling::
        //child::
        //descendant::
        driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//descendant::span[contains(text(),'Cart')]"));

        driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div/ancestor::*/li/child::*/following-sibling::div/div/p/parent::div"));
    }

//    @Test
    public void TC_04() {
        // Exercises
        //Sign up to get username & password
        driver.get("https://demo.guru99.com/");

        //Get back here to sign in
        driver.get("https://demo.guru99.com/v4/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
