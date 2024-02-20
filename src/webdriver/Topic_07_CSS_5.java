package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_CSS_5 {

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

        // and
        driver.findElement(By.cssSelector("input[id='email'][title='Email Address']"));

        // or
        driver.findElement(By.cssSelector("input[id='email'],[title='Email Address']"));

        // not
        driver.findElement(By.cssSelector("input:not([id='email'])"));
        driver.findElement(By.cssSelector("input:not(#email)"));
        driver.findElement(By.cssSelector("div:not(.new-user)"));
    }

    @Test
    public void TC_02() {
        driver.get("http://live.techpanda.org/index.php/mobile.html");
        // CSS + means 1 direct next to following-siblings::
        // CSS ~ means all next to following-siblings::

        driver.findElements(By.cssSelector("a.product-image[title='Xperia'] + div h2 ~div"));

    }

//    @Test
    public void TC_03() {

    }

//    @Test
    public void TC_04() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
