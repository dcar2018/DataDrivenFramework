package com.company.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) throws IOException {







        //** Read from property files
        System.out.println(System.getProperty("user.dir")); //C:\AutoSamples\dcar2018_Udemy\DataDrivenFramework

        Properties config = new Properties();
        Properties or = new Properties();
        //C:\AutoSamples\dcar2018_Udemy\DataDrivenFramework\src\test\resources\properties\OR.properties
        //FileInputStream fis = new FileInputStream("C:\\AutoSamples\\dcar2018_Udemy\\DataDrivenFramework\\src\\test\\resources\\properties\\OR.properties");
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
        //Load  the file
        config.load(fis);

        fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
        //Load  the file
        or.load(fis);



        System.out.println(config.getProperty("browser")); //chrome
        System.out.println(or.getProperty("bmlBtn")); //div > div:last-child > .btn.btn-primary.btn-lg


    }
}
