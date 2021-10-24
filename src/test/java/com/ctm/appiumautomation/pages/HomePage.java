package com.ctm.appiumautomation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Hello John\"`]")
    @AndroidFindBy(id = "welcomeText")
    private MobileElement welcomeMemberText;

//    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Compare\")")
//    private MobileElement compareTab;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Home\"`]")
    @AndroidFindBy(xpath = "(//*[@text='Home'])[2]/..")
    private MobileElement homeTab;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Compare\"`]")
    @AndroidFindBy(xpath = "(//*[@text='Compare'])[2]/..")
    private MobileElement compareTab;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Rewards\"`]")
    @AndroidFindBy(xpath = "(//*[@text='Rewards'])[1]/..")
    private MobileElement rewardsTab;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Finances\"`]")
    @AndroidFindBy(xpath = "(//*[@text='Finances'])[1]/..")
    private MobileElement financesTab;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Account\"`]")
    @AndroidFindBy(xpath = "(//*[@text='Account'])[1]/..")
    private MobileElement accountTab;

    public HomePage stayOnHomePage() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMemberText));
        return this;
    }

    public ComparePage goToComparePage() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMemberText));
        compareTab.click();
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return new ComparePage(driver);
    }

    public RewardsPage goToRewardsPage() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMemberText));
        rewardsTab.click();
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return new RewardsPage(driver);
    }

}
