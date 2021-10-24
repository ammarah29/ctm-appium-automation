package com.ctm.appiumautomation.pages;

import com.ctm.appiumautomation.utils.PropertiesManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CookiePage extends BasePage {

    public CookiePage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @iOSXCUITFindBy(className = "android.widget.TextView")
    @AndroidFindBy(className = "android.widget.TextView")
    private MobileElement privacySettings;

    @AndroidFindBy(id = "trackingConsentSaveButton")
    private MobileElement saveAndContinue;

    @AndroidFindBy(id = "trackingConsentAcceptAllButton")
    private MobileElement acceptAllAndContinue;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Marketing\")")
    private MobileElement marketingButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Functionality\")")
    private MobileElement functionalityButton;

    @iOSXCUITFindBy(id = "Ask App not to Track")
    private MobileElement askNotToTrackButton;
/*
    public CookiePage tapMarketingButton() {
        marketingButton.click();
        scrollDown();
        return this;
    }*/

    public OnboardingStartupPage goToShowcasePage() {
        if (PropertiesManager.instance.getPlatform().equals("ios")){
            askNotToTrackButton.click();
        } else if (PropertiesManager.instance.getPlatform().equals("android")) {
            wait.until(ExpectedConditions.visibilityOf(privacySettings));
            scrollDown();
            wait.until(ExpectedConditions.visibilityOf(saveAndContinue));
            saveAndContinue.click();
        }
        return new OnboardingStartupPage(driver);
    }

}
