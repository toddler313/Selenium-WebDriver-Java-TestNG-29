package listener;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import testNG.TC09_Listener_ITestListener;
import testNG.tiki.admin.BaseTest;
import java.io.File;
import java.io.IOException;

public class ExtendReportListener extends BaseTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot shot = (TakesScreenshot) (new TC09_Listener_ITestListener()).getWebDriver();
        File srcFile = shot.getScreenshotAs(OutputType.FILE);
        try {
            File destFile = new File("./screenshot/" + result.getName() + ".jpg");
            FileUtils.copyFile(srcFile, destFile);
            Reporter.log("<a href'" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
                        + "' height='100' width='100'/> </a>");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
