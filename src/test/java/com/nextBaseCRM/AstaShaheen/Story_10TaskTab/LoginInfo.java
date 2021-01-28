package com.nextBaseCRM.AstaShaheen.Story_10TaskTab;

import com.nextBaseCRM.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginInfo {

//testing from github
   public static WebDriver driver;

    public static void LogIn() {


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com/login");

        WebElement userName = driver.findElement(By.name("USER_LOGIN"));
        userName.sendKeys("hr35@cybertekschool.com");

//        "hr35@cybertekschool.com"
//        "hr36@cybertekschool.com"
//        "marketing35@cybertekschool.com"
//        "marketing36@cybertekschool.com"
//        "helpdesk35@cybertekschool.com"
//        "helpdesk36@cybertekschool.com"

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser", Keys.ENTER);


    }

}
