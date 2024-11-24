package org.WebAutomationFrameWork.tests.sample;

import org.WebAutomationFrameWork.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppVmoLogin {
    @BeforeTest
    public void setUp(){
        DriverManager.init();// if you don't call this function then you will get null
        // we are calling this from DriverManager to set the driver in @Test line no 21
    }


    @Test
    public void testLoginNegativeVWO() {
        //DriverManager.setDriver(null);
        WebDriver driver = DriverManager.getDriver();// Driver is set after call the init funtion from DriverManager
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");


        WebElement emailInputBox = driver.findElement(By.id("login-username")); // Page Locator
        emailInputBox.sendKeys("admin@admin.com"); // Page Action

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin");

        driver.findElement(By.id("js-login-btn")).click();

        try {
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text = error_msg.getText();
        String error_msg_attribute_dataqa = error_msg.getAttribute("data-qa");
        System.out.println(error_msg_attribute_dataqa);

        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
        driver.quit();
    }

}
