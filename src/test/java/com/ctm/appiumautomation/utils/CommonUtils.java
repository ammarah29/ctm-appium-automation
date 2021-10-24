package com.ctm.appiumautomation.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class CommonUtils {

    protected static AppiumDriverLocalService service;
    public static Logger log = Logger.getLogger("root");
    public static RemoteWebDriver driver;
    public static ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<RemoteWebDriver>();
    public static FileInputStream fis;
    public static Properties config = new Properties();
    public static String platform;

    public static RemoteWebDriver getRemoteWebDriver() {
        return tlDriver.get();
    }

    public static void setRemoteWebDriver(RemoteWebDriver driver) {
        tlDriver.set(driver);
    }

    public static void setPlatform(String currentPlatform) {
        platform = currentPlatform;
    }

    public AppiumDriverLocalService startServer(Integer portNumber) throws InterruptedException {
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingPort(portNumber)
                .withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload")
                .withArgument(GeneralServerFlag.LOG_TIMESTAMP)
                .withLogFile(new File("src/test/resources/logs/appium.log"))); // Save appium logs to this path
        if (driver == null || driver.getSessionId() == null) {
            service.start();
            log.info("[SETUP] Appium server started on port " + portNumber);
        }
        return service;
    }

    public static String captureScreenshot() throws IOException { // Take a screenshot when test fails
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date today = Calendar.getInstance().getTime();
        String date = dateFormat.format(today);
        log.info("[SCREENSHOT] Capturing image");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "src/test/resources/screenshots/" + date + ".png";
        FileUtils.copyFile(file, new File(screenshotPath));
        log.info("[SCREENSHOT] Image saved: " + screenshotPath);
        return screenshotPath;
    }

    public static void logInfo(String logMessage) {
        log.info(logMessage); // Prints to resources/logs/application.log
        TestListener.getTest().info(logMessage); // Prints to report
    }

    public static void logError(String logMessage) {
        log.error(logMessage); // Prints to resources/logs/application.log
        TestListener.getTest().error(logMessage); // Prints to report
    }

}
