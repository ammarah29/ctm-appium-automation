package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HowManyOfYouAreDiningPage extends BasePage {

    public HowManyOfYouAreDiningPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"How many of you are dining?\")")
    private MobileElement howManyOfYouAreDining;

    @AndroidFindBy(id = "dinersCountinueBtn")
    private MobileElement continueButton;

    public HowManyOfYouAreDiningPage goToHowManyOfYouAreDiningPage() {
        wait.until(ExpectedConditions.visibilityOf(howManyOfYouAreDining));
        return this;
    }

    public MealsMembershipCardPage goToMealsMembershipCardPage() {
        wait.until(ExpectedConditions.visibilityOf(howManyOfYouAreDining));
        continueButton.click();
        return new MealsMembershipCardPage(driver);
    }

}
