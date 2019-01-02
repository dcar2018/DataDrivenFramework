package com.company.testcases;

import com.company.base.TestBase;
import com.company.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AddCustomerTest extends TestBase {

    //Excel data read to HashTable and used in the test
    @Test(dataProviderClass = TestUtil.class, dataProvider = "dp_ht")
    public void addCustomerTest(Hashtable<String, String> data) throws InterruptedException {

        if (!data.get("runmode").equals("Y")){
            throw new SkipException("Skipping the test case : AddCustomerTest as the run mode is NO for the data set");
        }
        click("addCustomerBtn_CSS");
        type("firstName_CSS", data.get("firstname"));
        type("lastName_CSS", data.get("lastname"));
        type("postcode_CSS", data.get("postcode"));
        click("addBtn_CSS");


        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        String actualText = alert.getText();
        alert.accept();

        Assert.assertTrue(actualText.contains(data.get("alerttext")));
        verifyContains(data.get("alerttext"),actualText);
        //alert.accept();
        log.debug("End Add Customer Test");
        Reporter.log("Reporter > End Add Customer Test");
        //Assert.fail("Customer not added successfully");
        Thread.sleep(2000);
    }





    /*


    //@Test(dataProvider = "getData") // modified with enhanced data provider in TestUtil
    @Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void addCustomerTest(String firstName, String lastName, String postcode, String alerttext, String runmode) throws InterruptedException {
        //driver.get(config.getProperty("testsiteurl"));

        //driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();
        //Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("addCustomerBtn"))));

        if (!TestUtil.isTestRunnable("AddCustomerTest", excel)) {
            throw new SkipException("Skipping the test : AddCustomerTest as the run mode NO");
        }
        if (!runmode.equals("Y")){
            throw new SkipException("Skipping the test case : AddCustomerTest as the run mode is NO for the data set");

        }
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
*/

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
