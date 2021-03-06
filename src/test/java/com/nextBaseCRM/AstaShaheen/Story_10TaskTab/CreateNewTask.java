package com.nextBaseCRM.AstaShaheen.Story_10TaskTab;

import com.github.javafaker.Faker;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class CreateNewTask extends LoginInfo{




    // Click on "Task" module

    @Test
    public void newTask() throws InterruptedException {
     LogIn();



        WebElement taskTab = driver.findElement(By.xpath("//li[@id='bx_left_menu_menu_tasks']"));//xpath("//a[@title='Tasks']"));//linkText("Tasks"));
        taskTab.click();

        WebElement newTask = driver.findElement(By.xpath(" //a[@id='tasks-buttonAdd']"));
        newTask.click();
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='side-panel-iframe']"));

        driver.switchTo().frame(iFrame);

        Faker faker = new Faker();
        String nameInput = faker.funnyName().name();

        WebElement taskName = driver.findElement(By.xpath("//div[@class='task-info-panel-title']//input"));
        taskName.sendKeys(nameInput);
        Thread.sleep(2000);

        WebElement checklist = driver.findElement(By.xpath("//span[@class='tasks-task-mpf-link'] "));
        checklist.click();

        WebElement checkListText = driver.findElement(By.xpath("//input[@class='js-id-checklist-is-form-title task-checklist-field-add']"));
        Thread.sleep(3000);
        checkListText.sendKeys("Testing", Keys.ENTER);
        checkListText.sendKeys("Testing2", Keys.ENTER);
        checkListText.sendKeys("Testing3", Keys.ENTER);
        checkListText.sendKeys("Testing4", Keys.ENTER);


        List<WebElement> checklistList = driver.findElements(By.xpath("//label[@class='block-read task-checklist-field-label']"));
        // System.out.println(checklistList.size());

        driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-success']")).click();
        driver.switchTo().parentFrame();
        Thread.sleep(3000);
        List<WebElement> allTasks = driver.findElements(By.xpath("//td[@class='main-grid-cell main-grid-cell-left']/../td[3]"));
        ArrayList<String> arrList = new ArrayList<>();

        for (WebElement each : allTasks) {

            arrList.add(each.getText());

        }
        System.out.println(arrList.get(arrList.size() - 1));

        String lastCreatedTaskName = arrList.get(arrList.size() - 1);

        Assert.assertEquals(nameInput, lastCreatedTaskName);
    }
}
