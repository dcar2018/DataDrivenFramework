package com.company.testcases;

import com.company.base.TestBase;
import com.company.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    //@Test(dataProvider = "getData") // modified with enhanced data provider in TestUtil
    @Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void addCustomerTest(String firstName, String lastName, String postcode, String alerttext) throws InterruptedException {
        //driver.get(config.getProperty("testsiteurl"));

        //driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();
        //Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("addCustomerBtn"))));

        //below line simplified with the custom class for click
        //driver.findElement(By.cssSelector(or.getProperty("addCustomerBtn_CSS"))).click();
        //driver.findElement(By.cssSelector(or.getProperty("firstName_CSS"))).sendKeys(firstName);
        //driver.findElement(By.cssSelector(or.getProperty("lastName_CSS"))).sendKeys(lastName);
        //driver.findElement(By.cssSelector(or.getProperty("postcode_CSS"))).sendKeys(postcode);
        //driver.findElement(By.cssSelector(or.getProperty("addBtn_CSS"))).click();
        click("addCustomerBtn_CSS");
        type("firstName_CSS", firstName);
        type("lastName_CSS", lastName);
        type("postcode_CSS", postcode);
        click("addBtn_CSS");


        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        String actualText = alert.getText();
        alert.accept();

        Assert.assertTrue(actualText.contains(alerttext));
        verifyContains(alerttext,actualText);
        //alert.accept();
        log.debug("End Add Customer Test");
        Reporter.log("Reporter > End Add Customer Test");
        //Assert.fail("Customer not added successfully");
        Thread.sleep(2000);
    }


    //below method enhanced and moved to TestUtil
    /*
    @DataProvider

    public Object[][] getData() {

        String sheetName = "AddCustomerTest";
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);
        log.debug("reading excel data rows and cols = " + rows + cols);
        Reporter.log("reading excel data rows and cols = " + rows + cols);
        Object[][] data = new Object[rows - 1][cols];

        for (int rowNum = 2; rowNum <= rows; rowNum++) {

            for (int colNum = 0; colNum < cols; colNum++) {
                data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
                log.debug("reading excel data " + data[rowNum - 2][colNum]);
            }
        }
        return data;
    }
    */
}
