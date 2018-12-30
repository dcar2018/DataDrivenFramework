package com.company.testcases;

import com.company.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {
        //below moved to listener
        //System.setProperty("org.uncommons.reportng.escape-output", "false");
        driver.get(config.getProperty("testsiteurl"));
        log.debug("Starting login as bank manager");
        driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("addCustomerBtn"))));
        Thread.sleep(2000);
        log.debug("End login as bank manager");
        Reporter.log("Reporter > End login as bank manager");
        //Assert.fail("I failed the test");

        //add log to Testng report
        //below moved to listener
        //Reporter.log("Reporter > End login as bank manager");
        //Reporter.log("<br>");
        //Reporter.log("<a href=\"C:\\AutoSamples\\dcar2018_Udemy\\resources\\img\\rose.jpeg\"> Screenshot</a>");
        //Reporter.log("<br>");
        //Reporter.log("<a target=\"_blank\" href=\"C:\\AutoSamples\\dcar2018_Udemy\\resources\\img\\download.jpeg\"><img src=\"C:\\AutoSamples\\dcar2018_Udemy\\resources\\img\\download.jpeg\" height=50 width=50></img></a>");


    }

}
