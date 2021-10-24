package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RewardsPage extends BasePage {

    public RewardsPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "rewardsRootContainer")
    private MobileElement yourRewards;

    @AndroidFindBy(id = "meals_reward_image")
    private MobileElement meerkatMealsImage;

    @AndroidFindBy(id = "movies_reward_image")
    private MobileElement meerkatMoviesImage;

    public RewardsPage stayRewardsPage() {
        wait.until(ExpectedConditions.visibilityOf(yourRewards));
        return this;
    }

    public MeerkatMealsWelcomeShowcasePage goToMeerkatMealsWelcomeShowcasePage() {
        wait.until(ExpectedConditions.visibilityOf(yourRewards));
        meerkatMealsImage.click();
        return new MeerkatMealsWelcomeShowcasePage(driver);    }

}
