package com.nextBaseCRM.AsiaBizub;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Drivers {

    private static WebDriver chromeDriver;

    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return chromeDriver;
    }

    public static void getURL(String url){
        getDriver().get(url);
    }

    public static void implicitWait(){
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


}
