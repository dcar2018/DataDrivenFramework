package com.company.listeners;

import com.company.base.TestBase;
import com.company.utilities.TestUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners extends TestBase implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        TestUtil.captureScreenshot();

        //Testng Reporting
        Reporter.log("<br>Capturing screenshots");
        Reporter.log("<br><a href=\""+TestUtil.screenshotName1+"\"> Screenshot 1 : PASS</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=\""+TestUtil.screenshotName2+"\"><img src=\""+TestUtil.screenshotName2+"\" height=50 width=50></img></a>");

    }


    public void onTestFailure(ITestResult iTestResult) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        TestUtil.captureScreenshot();

        //Testng Reporting
        Reporter.log("<br>Capturing screenshots");
        Reporter.log("<br><a href=\""+TestUtil.screenshotName1+"\"> Screenshot 1 : FAIL</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=\""+TestUtil.screenshotName2+"\"><img src=\""+TestUtil.screenshotName2+"\" height=50 width=50></img></a>");

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
