package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PostSignInMemberPage extends BasePage {

    public PostSignInMemberPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Choose restaurants, order a takeaway or browse movies and find everything you need to enjoy your rewards in the app.\"`]")
    @AndroidFindBy(id = "bodyBottom")
    private MobileElement textOnPostMemberPage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ok, got it\"`]")
    @AndroidFindBy(id = "okGotItButton")
    private MobileElement okGotItButton;

    public HomePage goHomeScreen() {
        wait.until(ExpectedConditions.visibilityOf(textOnPostMemberPage));
        okGotItButton.click();
        return new HomePage(driver);
    }

}
