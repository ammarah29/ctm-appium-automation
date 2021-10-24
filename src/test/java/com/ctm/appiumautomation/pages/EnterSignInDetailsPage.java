package com.ctm.appiumautomation.pages;

import com.ctm.appiumautomation.utils.PropertiesManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EnterSignInDetailsPage extends BasePage {

    public EnterSignInDetailsPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"This should be the same email address you use to sign in to comparethemarket.com\"`]")
    @AndroidFindBy(id = "email_explanation")
    private MobileElement emailExplanation;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"textfield-email\"`]")
    @AndroidFindBy(id = "txtEmail")
    private MobileElement typeEmailAddress;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continue\"`]")
    private MobileElement continueButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`name == \"textfield-password\"`]\n")
    @AndroidFindBy(id = "txtPassword")
    private MobileElement typePassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Sign in\"`]")
    @AndroidFindBy(id = "btnSignIn")
    private MobileElement signInButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"I don't know my password\"`]")
    @AndroidFindBy(id = "lblForgotPassword")
    private MobileElement forgottenPasswordButton;

    public PostSignInMemberPage goToPostSignInMemberPage() {
        wait.until(ExpectedConditions.visibilityOf(emailExplanation));
        if (PropertiesManager.instance.getPlatform().equals("ios")) {
            typeEmailAddress.clear();
        }
        typeEmailAddress.sendKeys("mm.active@emailreaction.org");
        if (PropertiesManager.instance.getPlatform().equals("ios")) {
            continueButton.click();
        }
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        if (PropertiesManager.instance.getPlatform().equals("ios")) {
            signInButton.click();
        }
        if (PropertiesManager.instance.getPlatform().equals("android")) {
            typePassword.sendKeys("active123");
            signInButton.click();        }
        return new PostSignInMemberPage(driver);
    }

}
