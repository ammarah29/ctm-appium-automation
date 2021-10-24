package com.ctm.appiumautomation.pages;

import com.ctm.appiumautomation.utils.PropertiesManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GetHandyAlertsPage extends BasePage {

    public GetHandyAlertsPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Get handy alerts\"`]")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Get handy alerts\")")
    private MobileElement showcaseTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Allow notifications\"`]")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"NEXT\")")
    private MobileElement primaryButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Allow\"`]")
    private MobileElement allowButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Next\"`]")
    private MobileElement nextButton;

    public SignInPage goToSignInScreen() {
        wait.until(ExpectedConditions.visibilityOf(showcaseTitle));
        primaryButton.click();
        if (PropertiesManager.instance.getPlatform().equals("ios")){
            allowButton.click();
            nextButton.click();
        }
        return new SignInPage(driver);
    }

}
