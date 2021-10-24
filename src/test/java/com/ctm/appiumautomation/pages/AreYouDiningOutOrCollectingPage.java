package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AreYouDiningOutOrCollectingPage extends BasePage {

    public AreYouDiningOutOrCollectingPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Are you dining out or collecting?\")")
    private MobileElement areYouDiningOutOrCollecting;

    @AndroidFindBy(id = "dineInCTA")
    private MobileElement diningOutButton;

    @AndroidFindBy(id = "collectingCTA")
    private MobileElement collectingButton;

    public AreYouDiningOutOrCollectingPage stayOnAreYouDiningOutOrCollectingPage() {
        wait.until(ExpectedConditions.visibilityOf(areYouDiningOutOrCollecting));
        return this;
    }

    public WhereAreYouDiningPage goToWhereAreYouDiningPage() {
        wait.until(ExpectedConditions.visibilityOf(areYouDiningOutOrCollecting));
        diningOutButton.click();
        return new WhereAreYouDiningPage(driver);
    }

}
