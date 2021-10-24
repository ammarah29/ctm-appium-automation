package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OnboardingStartupPage extends BasePage {

    public OnboardingStartupPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(id = "showcase-continue")
    @AndroidFindBy(id = "primaryButton")
    private MobileElement showcaseNext;

    @iOSXCUITFindBy(id = "Welcome to Meerkat")
    @AndroidFindBy(id = "showcaseTitle")
    private MobileElement showcaseTitle;

    public FindRewardsNearYouPage goToFindRewardsNearYou() {
        wait.until(ExpectedConditions.visibilityOf(showcaseTitle));
        showcaseNext.click();
        return new FindRewardsNearYouPage(driver);
    }

}
