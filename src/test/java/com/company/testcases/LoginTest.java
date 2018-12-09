package com.company.testcases;

import com.company.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {

        driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();
        Thread.sleep(2000);
    }

}
