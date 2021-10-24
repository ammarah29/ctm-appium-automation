package com.ctm.appiumautomation.pages;

import com.ctm.appiumautomation.utils.PropertiesManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindRewardsNearYouPage extends BasePage {

    public FindRewardsNearYouPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Find your nearest reward\"`]")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Find rewards near you\")")
    private MobileElement showcaseTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Use my location\"`]")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"USE MY LOCATION\")")
    private MobileElement primaryButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Next\"`]")
    private MobileElement nextButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Allow While Using App\"`]")
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement whileUsingTheApp;

    public GetHandyAlertsPage goToGetHandyAlerts() {
        wait.until(ExpectedConditions.visibilityOf(showcaseTitle));
        primaryButton.click();
        whileUsingTheApp.click();
        if (PropertiesManager.instance.getPlatform().equals("ios")){
            nextButton.click();
        }
        return new GetHandyAlertsPage(driver);
    }

}
