package com.ctm.appiumautomation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum PropertiesManager {
    instance;

    private final Properties properties;
    private static final String defaultPropertiesPath = "src/test/resources/properties/config.properties";
    private static final String platform = "defaultPlatform";
    private static final String apk = "apk";
    private static final String appPackage = "appPackage";
    private static final String appActivity = "appActivity";
    private static final String automationNameAndroid = "automationNameAndroid";
    private static final String avd = "avd";
    private static final String deviceNameAndroid = "deviceNameAndroid";
    private static final String platformVersionAndroid = "platformVersionAndroid";
    private static final String ipa = "ipa";
    private static final String bundleId = "bundleId";
    private static final String automationNameiOS = "automationNameiOS";
    private static final String deviceNameiOS = "deviceNameiOS";
    private static final String platformVersioniOS = "platformVersioniOS";

    PropertiesManager() {
        properties = new Properties();
        try {
         loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadProperties() throws IOException {
        File defaultProperties = new File(defaultPropertiesPath);
        if (defaultProperties.exists()) {
            loadPropertiesFromPath(defaultPropertiesPath);
        }
    }

    private void loadPropertiesFromPath(String path) throws IOException {
        properties.load(new FileInputStream(path));
    }

    private String getProperty(String key) { // Get settings from properties file
        if (properties.getProperty(key) != null) {
            return properties.getProperty(key);
        } else {
            CommonUtils.logError("Unable to find property " + key + "in properties file");
            return null;
        }
    }

    public String getPlatform() {
        if (System.getProperty("platform") != null) {
            return System.getProperty("platform").toLowerCase();
        } else {
            return getProperty(platform).toLowerCase();
        }
    }

    public String getApk() {
        return getProperty(apk);
    }

    public String getAppPackage() {
        return getProperty(appPackage);
    }

    public String getAppActivity() {
        return getProperty(appActivity);
    }

    public String getAutomationNameAndroid() {
        return getProperty(automationNameAndroid);
    }

    public String getAvd() {
        return getProperty(avd);
    }

    public String getDeviceNameAndroid() {
        return getProperty(deviceNameAndroid);
    }

    public String getPlatformVersionAndroid() {
        return getProperty(platformVersionAndroid);
    }

    public String getIpa() {
        return getProperty(ipa);
    }

    public String getBundleId() {
        return getProperty(bundleId);
    }

    public String getAutomationNameiOS() {
        return getProperty(automationNameiOS);
    }

    public String getDeviceNameiOS() {
        return getProperty(deviceNameiOS);
    }

    public String getPlatformVersioniOS() {
        return getProperty(platformVersioniOS);
    }

}
