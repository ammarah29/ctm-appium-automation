package com.ctm.appiumautomation.pages;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage {

    public RemoteWebDriver driver;
    public WebDriverWait wait;

    public BasePage(RemoteWebDriver driver) { // Driver to wait 30 secs before timing out
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void scrollDown() {
        Dimension dimension = driver.manage().window().getSize();
        double scrollHeightStart = dimension.getHeight() * 0.5;
        int scrollStart = (int) scrollHeightStart;

        double scrollHeightEnd = dimension.getHeight() * 0.1;
        int scrollEnd = (int) scrollHeightEnd;

        swipe(0, scrollStart,0,  scrollEnd);
    }

    public void swipe(int fromX, int fromY, int toX, int toY) {
        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        action
                .press(point(fromX, fromY))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2)))
                .moveTo(point(toX, toY))
                .release()
                .perform();
    }

}
