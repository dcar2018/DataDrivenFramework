package com.company.utilities;

import com.company.base.TestBase;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.company.base.TestBase.driver;

public class TestUtil extends TestBase {

    //public static String screenshotPath = System.getProperty("user.dir")+"target\\surefire-reports\\html\\error.jpg";
    public static String screenshotName1 ;
    public static String screenshotName2 ;

    public static void captureScreenshot(){
        String screenshotPath1 = System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\";
        String screenshotPath2 = System.getProperty("user.dir")+"\\test-output\\html\\";

        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss_SSS").format(new Date());
        screenshotName1 = screenshotPath1 + "screenshot1_"+timestamp.toString()+".png";
        screenshotName2 = screenshotPath2 + "screenshot2_"+timestamp.toString()+".png";


        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File(screenshotName1));
            FileUtils.copyFile(scrFile, new File(screenshotName2));
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception ee) {
            ee.printStackTrace();
        }



    }
}
