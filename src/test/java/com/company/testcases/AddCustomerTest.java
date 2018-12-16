package com.company.testcases;

import com.company.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String postcode,String alerttext) throws InterruptedException {

        driver.findElement(By.cssSelector(or.getProperty("addCustomerBtn"))).click();
        driver.findElement(By.cssSelector(or.getProperty("firstName"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(or.getProperty("lastName"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(or.getProperty("postcode"))).sendKeys(postcode);

        driver.findElement(By.cssSelector(or.getProperty("addBtn"))).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        Assert.assertTrue(alert.getText().contains(alerttext));

    }

    @DataProvider
    public Object[][] getData() {

        String sheetName = "AddCustomerTest";
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);
        log.debug("reading excel data rows and cols = " + rows+cols);
        Reporter.log("reading excel data rows and cols = " + rows+cols);
        Object[][] data = new Object[rows - 1][cols];

        for (int rowNum = 2; rowNum <= rows; rowNum++) {

            for (int colNum = 0; colNum < cols; colNum++) {
                data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
                log.debug("reading excel data " + data[rowNum - 2][colNum]);
            }
        }
        return data;
    }

}
