package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PreviousQuotesPage extends BasePage {

    public PreviousQuotesPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Products\")")
    private MobileElement productsTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Previous Quotes\n\")")
    private MobileElement previousQuotesTab;

    @AndroidFindBy(id = "previousQuotesCard")
    private MobileElement previousQuotesCard;

    public PreviousQuotesPage stayOnPreviousQuotesTab() {
        wait.until(ExpectedConditions.visibilityOf(previousQuotesCard));
        return this;
    }

}
