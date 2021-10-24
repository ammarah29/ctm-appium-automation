package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MeerkatMealsHomePage extends BasePage {

    public MeerkatMealsHomePage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "restaurantOptionsTab")
    private MobileElement diningOptions;

    @AndroidFindBy(accessibility = "Use your Membership card now")
    private MobileElement membershipCard;

    public MeerkatMealsHomePage stayOnMeerkatMealsHomePage() {
        wait.until(ExpectedConditions.visibilityOf(diningOptions));
        return this;
    }

    public AreYouDiningOutOrCollectingPage goToAreYouDiningOutOrCollectingPage() {
        wait.until(ExpectedConditions.visibilityOf(diningOptions));
        membershipCard.click();
        return new AreYouDiningOutOrCollectingPage(driver);
    }

}
