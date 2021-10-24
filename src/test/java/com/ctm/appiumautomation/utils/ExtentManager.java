package com.ctm.appiumautomation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager { // Used to generate extent reports

    private static ExtentReports extent;
    private static String reportFileName = "TestResults.html"; // Name of report file
    private static String macReportFileLocation = "reports/" + reportFileName; // Path to report file

    public static ExtentReports generateReport() {
        if (extent == null) {
            String fileName = macReportFileLocation;
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
            htmlReporter.config().setTheme(Theme.DARK);
            htmlReporter.config().setDocumentTitle(fileName);
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName(fileName);
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}
