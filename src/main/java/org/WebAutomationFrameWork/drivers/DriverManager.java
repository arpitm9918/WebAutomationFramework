package org.WebAutomationFrameWork.drivers;

import org.WebAutomationFrameWork.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//This class Manage the driver which ever we want we tell them
// driver that we is mentioned in data properties file under resources folder
public class DriverManager {
    public static WebDriver driver;//this will be always shared

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init() {//this is initialization of webdriver

                               //this function use to start the driver
        String browser = null;
        browser = PropertyReader.readKey("browser");//Here PropertyReader utlility gives the browser to driver
                                                    // PropertyReader is present in utils folder
                                                    //Here we are reading the browser key
        browser = browser.toLowerCase();
        if (driver == null) {
            switch (browser) {
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    System.out.println("Not browser Found!!");
            }

        }
    }

    public static void down() {// this function is used to close the driver
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}
//One we need to create this
// by using this (driver manager) you can get the web driver
// you can set the webdriver