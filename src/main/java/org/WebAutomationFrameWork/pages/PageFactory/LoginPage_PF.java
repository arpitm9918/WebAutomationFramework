package org.WebAutomationFrameWork.pages.PageFactory;

import org.WebAutomationFrameWork.base.CommonToAllPage;
import org.WebAutomationFrameWork.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends CommonToAllPage {
    // Page Locators

    public LoginPage_PF(WebDriver driver) {//here object is createdLoginPage_PF
                                           // In POM elemets are initialized line by line
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-username")
    private WebElement username;
    //@FindBy Annotation will load all the elements automatically the moment you load this page(LoginPage_PF).
    //@FindBy will basically give you flexibility to initializing the element automatically
    //Automatically means when you call the constructor or when the object of thid class created all the elemnts initialized
    //Disadvantage :- when the moments page changes you will get stale elemnts exception

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;



    // Page Actions
    // Page Actions
    public String loginToVWOInvalidCreds() {
        openVWOLoginURL();
        enterInput(username, PropertyReader.readKey("invalid_username"));
        enterInput(password,PropertyReader.readKey("invalid_password"));
        clickElement(signButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return error_message.getText();
    }

}
