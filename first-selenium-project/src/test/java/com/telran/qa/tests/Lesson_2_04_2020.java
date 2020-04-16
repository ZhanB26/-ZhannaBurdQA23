package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Lesson_2_04_2020 {
    WebDriver wd;

    @BeforeClass
    public void setUP() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        //wd.get("http://jira.tel-ran.net/secure/Dashboard.jspa");
        wd.navigate().to("http://jira.tel-ran.net/secure/Dashboard.jspa");
    }

    @Test
    public void testJiraLogin() {
        //click()before Refactoring
        //wd.findElement(By.name("os_username")).click();

        // 1st block before Refactoring
        ////click(By.name("os_username"));
        //wd.findElement(By.name("os_username")).clear();
        //wd.findElement(By.name("os_username")).sendKeys("Zhanna");

        // 1st block after Refactoring
        type(By.name("os_username"), "Zhanna");


        // 2nd block before Refactoring
        //click(By.name("os_password"));
        //wd.findElement(By.name("os_password")).clear();
        //wd.findElement(By.name("os_password")).sendKeys("12345");

        // 2nd block after Refactoring
        type(By.name("os_password"), "12345");

        //Code before Refactoring
        //wd.findElement(By.id("login")).click();

        click(By.id("login"));

        //1st option
        //Assert.assertTrue(isElementPresent());

        //2nd option
        /*Assert.assertTrue(isElementPresent(By.id("usernameerror")));*/

        //3d option
        Assert.assertTrue(isElementPresent(By.id("usernameerror")));

        String errorMessage = wd.findElement(By.id("usernameerror")).getText();

        Assert.assertEquals(errorMessage, "Sorry, your username and password are incorrect - please try again.");
    }

    // type() method before refactoring
    /*public void type() {
        click(By.name("os_username"));
        wd.findElement(By.name("os_username")).clear();
        wd.findElement(By.name("os_username")).sendKeys("Zhanna");
    }*/

    // type() method
    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    // click() method
    public  void click(By locator){
        wd.findElement(locator).click();
    }


    //1st option see assertTrue 1st option
    /*public boolean isElementPresent(){
        return wd.findElements(By.id("usernameerror")).size() > 0;
    }*/  //1st option see assertTrue 1st option

    //2nd option see assertTrue 2nd option
    /*public boolean isElementPresent(By locator){
        return wd.findElements(locator).size() > 0;
    }*/

    //3d option see assertTrue 3d option
    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }



    @AfterClass
    public void tearDown() {
        // wd.quit();

    }

}
