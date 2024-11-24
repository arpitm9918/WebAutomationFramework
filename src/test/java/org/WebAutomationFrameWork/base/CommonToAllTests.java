package org.WebAutomationFrameWork.base;

import org.WebAutomationFrameWork.drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class CommonToAllTests {
    public class CommonToAllTest {

        @BeforeTest
        public void setUp() {
            DriverManager.init();
        }

        // Who will close the Webdriver
        @AfterTest
        public void tearDown() {
            DriverManager.down();
        }
    }
}
