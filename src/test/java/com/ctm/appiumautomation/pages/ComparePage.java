package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComparePage extends BasePage {

    public ComparePage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Products\")")
    private MobileElement productsTab;

    @AndroidFindBy(accessibility = "Previous Quotes")
    private MobileElement previousQuotesTab;

    public ComparePage stayOnComparePage() {
        wait.until(ExpectedConditions.visibilityOf(productsTab));
        return this;
    }

    public ComparePage goToPreviousQuotesTab() {
        wait.until(ExpectedConditions.visibilityOf(previousQuotesTab));
        previousQuotesTab.click();
        return this;
    }

}
