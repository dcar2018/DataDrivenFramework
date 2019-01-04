package com.company.listeners;

import com.company.base.TestBase;
import com.company.utilities.MonitoringMail;
import com.company.utilities.TestConfig;
import com.company.utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;

import javax.mail.MessagingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {

    public void onTestStart(ITestResult iTestResult) {
        ///Below for Extent Reports - to start the test
        extentTest = extentReport.startTest(iTestResult.getName().toUpperCase());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        TestUtil.captureScreenshot();

        //Testng Reporting
        Reporter.log("<br>Capturing screenshots");
        Reporter.log("<br><a href=\"" + TestUtil.screenshotName1 + "\"> Screenshot 1 : PASS</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=\"" + TestUtil.screenshotName2 + "\"><img src=\"" + TestUtil.screenshotName2 + "\" height=50 width=50></img></a>");

        ///Below for Extent Reports
        extentTest.log(LogStatus.PASS, iTestResult.getName().toUpperCase(), " PASS");
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(TestUtil.screenshotName1));
        extentReport.endTest(extentTest);
        extentReport.flush();

    }


    public void onTestFailure(ITestResult iTestResult) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        TestUtil.captureScreenshot();

        //Testng Reporting
        Reporter.log("<br>Capturing screenshots");
        Reporter.log("<br><a href=\"" + TestUtil.screenshotName1 + "\"> Screenshot 1 : FAIL</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=\"" + TestUtil.screenshotName2 + "\"><img src=\"" + TestUtil.screenshotName2 + "\" height=50 width=50></img></a>");

        ///Below for Extent Reports
        extentTest.log(LogStatus.FAIL, iTestResult.getName().toUpperCase(), " FAILED with exception : " + iTestResult.getThrowable());
        extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(TestUtil.screenshotName1));
        extentReport.endTest(extentTest);
        extentReport.flush();

    }

    public void onTestSkipped(ITestResult iTestResult) {

        extentTest.log(LogStatus.SKIP, iTestResult.getName().toUpperCase()+" Skipped the test as the run mode is NO");
        extentReport.endTest(extentTest);
        extentReport.flush();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

    public void onStart(ISuite iSuite) {

    }

    public void onFinish(ISuite iSuite) {
        try {
        MonitoringMail mail = new MonitoringMail();

        String messageBody = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/job/DataDrivenFramework/Extent_20HTML_20Test_20Results_20Report/";
        System.out.println("messageBody = " + messageBody);

            mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
