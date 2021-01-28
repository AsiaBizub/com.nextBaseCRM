package com.nextBaseCRM.AstaShaheen.Story_10TaskTab;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.Date;

public class AddDeadline extends LoginInfo {



    @Test
    public void addingDeadline() throws InterruptedException {

       LogIn();
        WebElement taskTab = driver.findElement(By.xpath("//li[@id='bx_left_menu_menu_tasks']"));//xpath("//a[@title='Tasks']"));//linkText("Tasks"));
        taskTab.click();
        WebElement deadline= driver.findElement(By.xpath("//div[@class='main-grid-container']//tr[1]//td[4]"));
        deadline.click();
        LocalDate.now().plusDays(1);
//a[@class='bx-calendar-cell']
        //a[contains(text(),'28')][@class='bx-calendar-cell bx-calendar-active']

Thread.sleep(3000);




    }

}
