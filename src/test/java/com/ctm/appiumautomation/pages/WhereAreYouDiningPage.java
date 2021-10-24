package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WhereAreYouDiningPage extends BasePage {

    public WhereAreYouDiningPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Where are you dining?\")")
    private MobileElement whereAreYouDining;

    @AndroidFindBy(xpath = "(//*[@text='Account'])[1]/..")
    private MobileElement accountTab;

    @AndroidFindBy(id = "restaurantTitle")
    private MobileElement restaurantTitle;

    public WhereAreYouDiningPage stayOnWhereAreYouDiningPage() {
        wait.until(ExpectedConditions.visibilityOf(whereAreYouDining));
        return this;
    }

    public HowManyOfYouAreDiningPage goToHowManyOfYouAreDiningPage() {
        wait.until(ExpectedConditions.visibilityOf(whereAreYouDining));
        restaurantTitle.click();
        return new HowManyOfYouAreDiningPage(driver);
    }

}
