package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_Exercise_CSS_6_Tooltip_CDropdown {

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
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }


    // SEE TOPIC 17

//    @Test
    public void TC_01_Tooltip() {
        // TIPS & TRICKS
        // Browser Dev Tools - Go Network -> Switch to Slow network (GPRS / Offline)
        // Browser Dev Tools - Go Debugger (FF) | Source (Chrome) to trigger debug mode

        // Use debug (F8) when hovering on tooltip

        // Alternatively, use javascript on Console
//        setTimeout(() => {
//          console.log('Turn on debugger after 1s');
//          debugger;
//        }, 1000);

        // Catch Tooltip message
//        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
//        driver.get("https://automationfc.github.io/jquery-tooltip//");



    }

    @Test
    public void TC_02_Register_with_Empty_Data() {


    }

    @Test
    public void TC_03_Invalid_Email_Address() {

    }

    @Test
    public void TC_04_Incorrect_Confirm_Email() {

    }

    @Test
    public void TC_05_Invalid_Password() {

    }

    @Test
    public void TC_06_Incorrect_Confirm_Password() {

    }

    @Test
    public void TC_07_Invalid_Phone() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
