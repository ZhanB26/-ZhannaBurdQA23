package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginJira {
WebDriver driver;

@BeforeClass
    public void setUp(){
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://jira.tel-ran.net/secure/Dashboard.jspa");

}

@Test
    public void loginJira() throws InterruptedException {
    // driver.findElement(By.id("login-form-username")).click();                                 //click inside Jira login username
    click("login-form-username");
    driver.findElement(By.id("login-form-username")).clear();                                //clear if Jira login username input was not clear
    driver.findElement(By.id("login-form-username")).sendKeys("xxyyzz261126");   //enter Jira login username

    //driver.findElement(By.id("login-form-password")).click();
    click("login-form-password");
    driver.findElement(By.id("login-form-password")).clear();
    driver.findElement(By.id("login-form-password")).sendKeys("xxyyzz26$");

    //driver.findElement(By.id("login")).click();
    click("login");

    Thread.sleep(3500);

}

    private void click(String s) {
        driver.findElement(By.id(s)).click();
    }

    @AfterClass
    public void tearDown(){
    driver.quit();
}

}
