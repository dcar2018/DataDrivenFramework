package com.company.testcases;

import com.company.base.TestBase;
import com.company.utilities.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void bankManagerLoginTest() throws InterruptedException {
        //below moved to listener
        //System.setProperty("org.uncommons.reportng.escape-output", "false");

        //driver.get(config.getProperty("testsiteurl")); //if need to start test from HomePage

        if (!TestUtil.isTestRunnable("BankManagerLoginTest", excel)) {
            throw new SkipException("Skipping the test : BankManagerLoginTest as the run mode NO");
        }
        //Below line for log4j legger
        log.debug("Starting login as bank manager");

        //SoftAssertion where the tests will still work even the verification fails
        verifyEquals("abc","xyz");

        //below line simplified with the custom class for click
        //driver.findElement(By.cssSelector(or.getProperty("bmlBtn_CSS"))).click();
        click("bmlBtn_CSS");

        Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("addCustomerBtn_CSS"))));
        Thread.sleep(2000);

        //Below line for log4j legger
        log.debug("End login as bank manager");

        //Below line for testng reporter
        Reporter.log("Reporter > End login as bank manager");
        Assert.fail("I failed the test");

        //add log to Testng report
        //below moved to listener
        //Reporter.log("Reporter > End login as bank manager");
        //Reporter.log("<br>");
        //Reporter.log("<a href=\"C:\\AutoSamples\\dcar2018_Udemy\\resources\\img\\rose.jpeg\"> Screenshot</a>");
        //Reporter.log("<br>");
        //Reporter.log("<a target=\"_blank\" href=\"C:\\AutoSamples\\dcar2018_Udemy\\resources\\img\\download.jpeg\"><img src=\"C:\\AutoSamples\\dcar2018_Udemy\\resources\\img\\download.jpeg\" height=50 width=50></img></a>");


    }

}
