package com.company.testcases;

import com.company.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {

        System.setProperty("org.uncommons.reportng.escape-output","false");
        log.debug("Starting login as bank manager");
        driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("addCustomerBtn"))));
        Thread.sleep(2000);
        log.debug("End login as bank manager");
        Reporter.log("Reporter > End login as bank manager");
        Reporter.log("<br>");
        Reporter.log("<a href=\"C:\\AutoSamples\\dcar2018_Udemy\\resources\\img\\image.jpg\">Screenshot </a>");
        Reporter.log("<br>");

        Reporter.log("<a target=\"_blank\" href=\"C:\\AutoSamples\\dcar2018_Udemy\\resources\\img\\image.jpg\"><img src=\"C:\\AutoSamples\\dcar2018_Udemy\\resources\\img\\image.jpg\"nheight=200 width=200></img></a>");


    }

}
