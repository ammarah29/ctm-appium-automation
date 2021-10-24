package com.ctm.appiumautomation.steps;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.ctm.appiumautomation.utils.CommonUtils;
import com.ctm.appiumautomation.utils.PropertiesManager;
import com.ctm.appiumautomation.utils.TestListener;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hooks extends CommonUtils {

    private void setup() {
        org.apache.log4j.PropertyConfigurator.configure("src/test/resources/logs/log4j.properties");
    }

    @Before
    public void setupScenario(Scenario scenario) throws IOException, InterruptedException { // Setup depending on platform
        setup();

        switch (PropertiesManager.instance.getPlatform()) {
            case "android":
                setupAndroid(scenario);
                break;
            case "ios":
                setupIos(scenario);
                break;
            default:
                logError("[SETUP] Invalid platform property");
                break;
        }
    }

    public void setupAndroid(Scenario scenario) throws IOException, InterruptedException {
        TestListener.createTest(scenario.getName(), "android");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesManager.instance.getDeviceNameAndroid());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesManager.instance.getPlatformVersionAndroid());
        capabilities.setCapability(AndroidMobileCapabilityType.AVD, PropertiesManager.instance.getAvd());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertiesManager.instance.getAutomationNameAndroid());
        capabilities.setCapability(MobileCapabilityType.PRINT_PAGE_SOURCE_ON_FIND_FAILURE, true);
        capabilities.setCapability(AndroidMobileCapabilityType.NATIVE_WEB_SCREENSHOT, true);
        capabilities.setCapability(MobileCapabilityType.APP, PropertiesManager.instance.getApk());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, PropertiesManager.instance.getAppPackage());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, PropertiesManager.instance.getAppActivity());
        startServer(4728);
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4728/wd/hub"), capabilities);
        setRemoteWebDriver(driver);
        setPlatform("android");
        getRemoteWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logInfo("[SETUP] Launching Android");
    }

    public void setupIos(Scenario scenario) throws IOException, InterruptedException {
        TestListener.createTest(scenario.getName(), "ios");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesManager.instance.getDeviceNameiOS());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesManager.instance.getPlatformVersioniOS());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertiesManager.instance.getAutomationNameiOS());
        capabilities.setCapability(MobileCapabilityType.PRINT_PAGE_SOURCE_ON_FIND_FAILURE, true);
        capabilities.setCapability(MobileCapabilityType.APP, PropertiesManager.instance.getIpa());
        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, PropertiesManager.instance.getBundleId());
        capabilities.setCapability("wdaStartupRetries", "4");
        capabilities.setCapability("iosInstallPause", "8000");
        capabilities.setCapability("wdaStartupRetryInterval", "20000");
        startServer(4729);
        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4729/wd/hub"), capabilities);
        setRemoteWebDriver(driver);
        setPlatform("ios");
        getRemoteWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logInfo("[SETUP] Launching iOS");
    }

    @After
    public void tearDown(Scenario scenario) { // If the scenario fails take a screenshot
        if (scenario.isFailed()) {
            try {
                TestListener.getTest().fail("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(CommonUtils.captureScreenshot()).build());
            } catch (IOException|NullPointerException e) {
                e.printStackTrace();
            }
        }
        if (getRemoteWebDriver() != null) {
            getRemoteWebDriver().quit();
            logInfo("[TEARDOWN] WebDriver stopped");
        }
        if (service != null) {
            service.stop();
            logInfo("[TEARDOWN] Appium server stopped");
        }
    }

}
