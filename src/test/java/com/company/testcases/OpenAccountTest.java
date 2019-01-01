package com.company.testcases;

import com.company.base.TestBase;
import com.company.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenAccountTest extends TestBase {

    @Test(dataProviderClass= TestUtil.class,dataProvider= "dp")
    public void openAccountTest(String customer, String currency) throws InterruptedException {

        click("openaccount_CSS");
        Thread.sleep(2000);
        select("customer_ID",customer);
        Thread.sleep(2000);
        select("currency_CSS",currency);
        click("process_CSS");


        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);

    }



}
