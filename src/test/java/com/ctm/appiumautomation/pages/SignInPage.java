package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePage {

    public SignInPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"To make the most of the Meerkat app, sign in with your comparethemarket.com account.\"`]")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"To make the most of the Meerkat app, sign in with your comparethemarket.com account\")")
    private MobileElement signInWelcomeText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Sign in\"`]")
    @AndroidFindBy(id = "btnSignInWithComparethemarket")
    private MobileElement signInButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Create account\"`]")
    @AndroidFindBy(id = "btnCreateAccount")
    private MobileElement createAnAccountButton;

    public EnterSignInDetailsPage goToEnterSignInDetailsScreen() {
        wait.until(ExpectedConditions.visibilityOf(signInWelcomeText));
        signInButton.click();
        System.out.println(driver.getPageSource());
        return new EnterSignInDetailsPage(driver);
    }

}
