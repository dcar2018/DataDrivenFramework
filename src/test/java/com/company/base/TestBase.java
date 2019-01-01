package com.company.base;

import com.company.utilities.ExcelReader;
import com.company.utilities.ExtentManager;
import com.company.utilities.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    /***
     *
     * WebDriver - done
     * Properties - done
     * Logs - log4j jar, .log. log4j.properties, Logger
     * ExtentReport
     * DB
     * Excel
     * Mail
     * ReportNG , ExtentReport
     ***/


    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties or = new Properties();
    public static FileInputStream fis;
    // public static Logger log = Logger.getLogger("devpinoyLogger");
    public static Logger log = Logger.getLogger("devpinoyLogger");
    // public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
    public static ExcelReader excel = new ExcelReader("C:\\AutoSamples\\dcar2018_Udemy\\DataDrivenFramework\\src\\test\\resources\\excel\\testdata.xlsx");
    public static WebDriverWait wait;

    public ExtentReports extentReport = ExtentManager.getInstance();
    public static ExtentTest extentTest;


    @BeforeSuite
    public void setUp() {

        if (driver == null) {

            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
                config.load(fis);
                log.debug("Config file loaded");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
                or.load(fis);
                log.debug("OR file loaded");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (config.getProperty("browser").equals("firefox")) {
                //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
                driver = new FirefoxDriver();
            } else if (config.getProperty("browser").equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
                driver = new ChromeDriver();
                log.debug("Chrome launched");
            } else if (config.getProperty("browser").equals("ie")) {
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }
        }

        driver.get(config.getProperty("testsiteurl"));
        log.debug("Navigated to " + config.getProperty("testsiteurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }


    public void click(String locator) {
        if (locator.endsWith("_CSS")) {
            driver.findElement(By.cssSelector(or.getProperty(locator))).click();
        } else if (locator.endsWith("_ID")) {
            driver.findElement(By.id(or.getProperty(locator))).click();
        } else if (locator.endsWith("_XPATH")) {
            driver.findElement(By.xpath(or.getProperty(locator))).click();
        } else if (locator.endsWith("_CLASSNAME")) {
            driver.findElement(By.className(or.getProperty(locator))).click();
        }

        //Add logs for extent reports
        extentTest.log(LogStatus.INFO, "Clicking on : " + locator);

    }

    public void type(String locator, String value) {

        if (locator.endsWith("_CSS")) {
            driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
        } else if (locator.endsWith("_ID")) {
            driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
        } else if (locator.endsWith("_XPATH")) {
            driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
        } else if (locator.endsWith("_CLASSNAME")) {
            driver.findElement(By.className(or.getProperty(locator))).sendKeys(value);
        }

        //Add logs for extent reports
        extentTest.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);

    }

    static WebElement dropdown;

    public void select(String locator, String value) {


        if (locator.endsWith("_CSS")) {
            dropdown = driver.findElement(By.cssSelector(or.getProperty(locator)));
        } else if (locator.endsWith("_ID")) {
            dropdown = driver.findElement(By.id(or.getProperty(locator)));
        } else if (locator.endsWith("_XPATH")) {
            dropdown = driver.findElement(By.xpath(or.getProperty(locator)));
        } else if (locator.endsWith("_CLASSNAME")) {
            dropdown = driver.findElement(By.className(or.getProperty(locator)));
        }
        //dropdown.sendKeys(Keys.ENTER);
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);

        //Add logs for extent reports
        extentTest.log(LogStatus.INFO, "Selecting from the drop down : " + locator + " select value as " + value);

    }


    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {

            return false;
        }

    }


    public static void verifyEquals(String expected, String actual) {

        try {
            Assert.assertEquals(actual, expected);

            System.setProperty("org.uncommons.reportng.escape-output", "false");

            //Testng Reporting
            Reporter.log("<br>Verification PASS for : " + actual + " / " + expected + "<br>");

            ///Below for Extent Reports
            extentTest.log(LogStatus.PASS, "Verifiction PASS for : " + actual + " / " + expected);

        } catch (Throwable t) {
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            TestUtil.captureScreenshot();

            //Testng Reporting
            Reporter.log("<br>Verification failure : " + t.getMessage() + "<br>");
            Reporter.log("<br><a target=\"_blank\" href=\"" + TestUtil.screenshotName2 + "\"><img src=\"" + TestUtil.screenshotName2 + "\" height=50 width=50></img></a>");

            ///Below for Extent Reports
            extentTest.log(LogStatus.FAIL, "Verifiction failure with exception : " + t.getMessage());
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(TestUtil.screenshotName1));
        }
    }


    public static void verifyContains(String expected, String actual) {

        try {
            Assert.assertTrue(actual.toLowerCase().contains(expected.toLowerCase()));

            System.setProperty("org.uncommons.reportng.escape-output", "false");

            //Testng Reporting
            Reporter.log("<br>Verification contains PASS for : " + actual + " / " + expected + "<br>");

            ///Below for Extent Reports
            extentTest.log(LogStatus.PASS, "Verifiction contains PASS for : " + actual + " / " + expected);

        } catch (Throwable t) {
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            TestUtil.captureScreenshot();

            //Testng Reporting
            Reporter.log("<br>Verification failure for contain : " + t.getMessage() + "<br>");
            Reporter.log("<br><a target=\"_blank\" href=\"" + TestUtil.screenshotName2 + "\"><img src=\"" + TestUtil.screenshotName2 + "\" height=50 width=50></img></a>");

            ///Below for Extent Reports
            extentTest.log(LogStatus.FAIL, "Verifiction failure for contain with exception : " + t.getMessage());
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(TestUtil.screenshotName1));
        }
    }




    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.debug("Test execution completed");
        }
    }


}
