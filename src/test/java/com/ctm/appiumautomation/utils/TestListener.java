package com.ctm.appiumautomation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static ExtentReports extent = ExtentManager.generateReport();
    private static ExtentTest test;
    public static String testName;
    public static String testCategory;

    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }

    public static synchronized  ExtentTest createTest(String name, String category) {
        test = extent.createTest(name);
        testName = name;
        test.assignCategory(category);
        testCategory = category;
        extentTest.set(test);
        return test;
    }

    public static synchronized void log(String message) {
        test.info(message);
    }

    @Override
    public synchronized void onStart(ITestContext context) {
        CommonUtils.log.info("[TEST] Suite started");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        CommonUtils.log.info("[TEARDOWN] Suite ended");
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        CommonUtils.log.info("[TEST] Started " + result.getMethod().getMethodName()); // Prints name of the test
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) // On test success
    {
        CommonUtils.log.info("[TEST] " + result.getMethod().getMethodName() + "PASSED");
        extentTest.get().pass("Test passed"); // Mark the test as passed in the report
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) { // On test failure
        extentTest.get().fail(result.getThrowable());
        try {
            extentTest.get().fail("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(CommonUtils.captureScreenshot()).build());
        } catch (IOException | NoSuchSessionException | NullPointerException e) {
            e.printStackTrace();
        }
        CommonUtils.log.info("[TEST] " + result.getMethod().getMethodName() + "FAILED!");
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) { //On test skipped
        CommonUtils.log.info("[TEST] " + result.getMethod().getMethodName() + " SKIPPED!");
        extentTest.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

}
