package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MeerkatMealsWelcomeShowcasePage extends BasePage {

    public MeerkatMealsWelcomeShowcasePage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "showcaseTitle")
    private MobileElement welcomeToMeerkatMeals;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"NEXT\")")
    private MobileElement nextButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Skip all\")")
    private MobileElement skipAllButton;

    public MeerkatMealsWelcomeShowcasePage stayRewardsPage() {
        wait.until(ExpectedConditions.visibilityOf(welcomeToMeerkatMeals));
        return this;
    }

    public MeerkatMealsWelcomeShowcasePage goToMeerkatMealsWelcomeShowcasePage() {
        wait.until(ExpectedConditions.visibilityOf(welcomeToMeerkatMeals));
        skipAllButton.click();
        return new MeerkatMealsWelcomeShowcasePage(driver);
    }

}
