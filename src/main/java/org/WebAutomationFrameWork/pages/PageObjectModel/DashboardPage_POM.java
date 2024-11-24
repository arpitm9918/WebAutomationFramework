package org.WebAutomationFrameWork.pages.PageObjectModel;

import org.WebAutomationFrameWork.base.CommonToAllPage;
import org.openqa.selenium.By;

public class DashboardPage_POM  extends CommonToAllPage {
    public DashboardPage_POM(){

    }


    // Page Locators
    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");





    // Page Actions
    public String loggedInUserName() {
        presenceOfElement(userNameOnDashboard); // These function are present in Common to all pages calss in Base package
        return getElement(userNameOnDashboard).getText();
    }
}
