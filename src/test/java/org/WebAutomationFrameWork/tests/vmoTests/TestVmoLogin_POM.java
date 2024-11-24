package org.WebAutomationFrameWork.tests.vmoTests;

import org.WebAutomationFrameWork.base.CommonToAllTests;
import org.WebAutomationFrameWork.drivers.DriverManager;
import org.WebAutomationFrameWork.pages.PageObjectModel.LoginPage_POM;
import org.WebAutomationFrameWork.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static org.WebAutomationFrameWork.drivers.DriverManager.driver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVmoLogin_POM extends CommonToAllTests {
   // To use log use below line and remember omprot Logger from apace log4j
    private static final Logger logger= LogManager.getLogger(TestVmoLogin_POM.class);

    //    @BeforeTest
//    public void setup(){ // Driver will be start by this // moved to base class
//    //we extends the base class class(CommonToAllTests)in this class to use this
//        DriverManager.init();
//    }
    @Test
    public void testLoginNegativeVWO(){
        logger.info("Starting the Testcases");// this is use to take the log

       // WebDriver driver = new EdgeDriver();//we dont need this line beaucuse we called the driver from drivermanager class
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());//1 st calling the class,
        // 2nd calling the driver by calling the driver from driverManager
        // if you want to use this then you need to use BeforeTest

      //  LoginPage_POM loginPagePom = new LoginPage_POM(driver);// calling the class
        logger.info("Opening the URL");// for log
        //String error_msg_text = loginPagePom.loginToVWOInvalidCreds("admin@gamil.com", "admin");// using the function Before noraml
        String error_msg_text = loginPagePom.loginToVWOInvalidCreds(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));
        //In above line we are using PropertyReade instead of Hard Code value
        Assert.assertEquals(error_msg_text,"Your email, password, IP address or location did not match");//Hard Coded Message
        Assert.assertEquals(error_msg_text, PropertyReader.readKey("error_message"));// Here we have used PropertyReader
       // driver.quit();// for this we will use teardown function


        logger.info("Verifying the Username is the" +error_msg_text);// for log

        //AssertJ Assertion
        assertThat(error_msg_text).isNotBlank().isNotNull().isNotEmpty();


    }
//    @AfterTest
//    public void tearDown(){// Driver will be close by this // Moved to base class
//     DriverManager.down();
//    }
}
//Note if you want to remove hard code value then you use PropertyReader
// In this we will not user BeforeTest and AfterTest
// We move BeforwTest and AfterTest in BaseClass
// To use both in this class we will use Single Inheritance
// Basically we exends base class

//What is POM?
// Page Object Model, also known as POM, is a design pattern in Selenium that creates an object
// repository for storing all web elements.
// It helps reduce code duplication and improves test case maintenance.
//In Page Object Model, consider each web page of an application as a class file.
// Each class file will contain only corresponding web page elements.
// Using these elements, testers can perform operations on the website under test.
//Advantage Of POM:-
//1. Easy Maintenance
//2. Code Resusibility
// POM says divide your pages (LoginPage, Dashboard Page)
// Every Page should have class
//   In class --- a) Page Locators
//                b) Page Actions