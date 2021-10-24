package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MealsMembershipCardPage extends BasePage {

    public MealsMembershipCardPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"How many of you are dining?\")")
    private MobileElement howManyOfYouAreDining;

    @AndroidFindBy(id = "mealsTabs")
    private MobileElement mealsMembershipCardTabsBar;

    @AndroidFindBy(id = "shimmer_view_container")
    private MobileElement mealsMembershipCard;

    public MealsMembershipCardPage goToHowManyOfYouAreDiningPage() {
        wait.until(ExpectedConditions.visibilityOf(mealsMembershipCardTabsBar));
        wait.until(ExpectedConditions.visibilityOf(mealsMembershipCard));
        return this;
    }

}
