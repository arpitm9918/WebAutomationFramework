package org.WebAutomationFrameWork.tests.vmoTests;

import org.WebAutomationFrameWork.base.CommonToAllTests;
import org.WebAutomationFrameWork.drivers.DriverManager;
import org.WebAutomationFrameWork.pages.PageFactory.LoginPage_PF;
import org.WebAutomationFrameWork.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class TestVmoLogin_PF extends CommonToAllTests {
//private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM.class);

    @Test
    public void testLoginNegativeVWO_PF() {
      //  logger.info("Starting the Testcases Page Factory");
        WebDriver driver = new EdgeDriver();
       // WebDriver driver= DriverManager.getDriver();
        driver.get("https://app.vmo.com");
       // driver.get(PropertyReader.readKey("url"));
        LoginPage_PF loginPage_PF = new LoginPage_PF(driver);
        String error_msg = loginPage_PF.loginToVWOInvalidCreds();
        Assert.assertEquals(error_msg, PropertyReader.readKey("error_message"));
        // for Browser start and end we have base class
    }
}
