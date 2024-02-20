package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_B_CSS_JQUERY_DOM {

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
        driver.get("https://automationfc.github.io/basic-form/");

        // Browser dev-tool Console tab
        // WAY to verify value recently entered into a text field element BUT NOT YET sent request to server.
        // Using ANY one of these below

//        $(document.evaluate("input#name", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).value;
//        $(document.evaluate("input#name", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val();
//        $(document.evaluate("input#name", document, null, XPathResult.STRING_TYPE, null).stringValue;
//        $("input#name").value;
//        $("input#name").val();

        // Using DOM
//        document.querySelector("input#name").value;

    }

    @Test
    public void TC_02() {
        //        $$("")  and  $x("")  - CSS and Xpath return an array => [0].attributes to get detail

        // let cartCSS = $$(".header-minicart > a");
        // cart[0].click();

        // let cartMessageCSS = $$("div#header-cart div.minicart-wrapper p.empty");

        // console.log(cartMessage[0].innerText);

        // cartMessage[0].textContent === "You have no items in your shopping cart."

        // let cartXPath = $x("//div[@class='header-minicart']/a");
        // cartXPath[0].click();

        // JQuery returns 1 element
        // $("a[title='Create an Account']");

        //DOM
        //        document.querySelector("a[title='Create an Account']").click();
        //        document.querySelector("a[title='Create an Account']").value;

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
