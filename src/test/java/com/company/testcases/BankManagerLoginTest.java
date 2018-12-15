package com.company.testcases;

import com.company.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {
        log.debug("Starting login as bank manager");
        driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("addCustomerBtn"))));
        Thread.sleep(2000);
        log.debug("End login as bank manager");
    }

}
