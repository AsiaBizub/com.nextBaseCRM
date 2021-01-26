package com.nextBaseCRM.AstaShaheen.Story_10TaskTab;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Asign_HighPriority extends LoginInfo {


    // Click on "Task" module


    @Test
    public void TaskPriority() throws InterruptedException {
        LogIn();

        WebElement taskTab = driver.findElement(By.xpath("//li[@id='bx_left_menu_menu_tasks']"));//xpath("//a[@title='Tasks']"));//linkText("Tasks"));
        taskTab.click();


        // From the task table click on first available task "name"

        WebElement firstSelection = driver.findElement(By.xpath("//div[@class='main-grid-container']//tr[1]//td[3]//a"));
        System.out.println(firstSelection.getText());
        firstSelection.click();


        //Move the mouse to "High priority"  on the top right corner of the page and click on it

        WebElement frame1 = driver.findElement(By.xpath("//*[@class='side-panel-iframe']"));
        driver.switchTo().frame(frame1);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement fireNotRed = driver.findElement(By.xpath("//span[@class='if-no']"));

        WebElement fireRed = driver.findElement(By.xpath("//span[@class='if-not-no'][text()='High Priority']"));

        if (fireRed.isDisplayed()) {
            System.out.println(" High Priority is already selected");
            Assert.assertTrue(fireRed.isDisplayed());
            fireRed.click();
            driver.navigate().refresh();
//driver.close();

        } else {

            fireNotRed.click();
            Thread.sleep(1000);


            driver.switchTo().parentFrame();

            driver.findElement(By.xpath("//span[@title='Close']")).click();
            driver.navigate().refresh();

            Thread.sleep(2000);

            driver.findElement(By.xpath("//li[@id='bx_left_menu_menu_tasks']")).click();

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


            WebElement prioritySet = driver.
                    findElement(By.xpath("//div[@class='main-grid-container']//tr[1]//td[3]//child::span[1]/span[1]//child::span[1]"));

            Assert.assertTrue(prioritySet.isDisplayed(), "High priority is NOT set!!!!");
            // driver.findElement(By.xpath("//div[@class='main-grid-container']//tr[1]//td[3]//a")).click();
            driver.navigate().refresh();
        }

    }

    @AfterTest
    public void tearDown() {

    }

}